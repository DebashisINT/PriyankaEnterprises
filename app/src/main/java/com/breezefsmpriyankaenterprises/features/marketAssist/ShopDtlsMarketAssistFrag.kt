package com.breezefsmpriyankaenterprises.features.marketAssist

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.breezefsmpriyankaenterprises.R
import com.breezefsmpriyankaenterprises.app.AppDatabase
import com.breezefsmpriyankaenterprises.app.Pref
import com.breezefsmpriyankaenterprises.app.domain.ShopActivityEntity
import com.breezefsmpriyankaenterprises.app.utils.AppUtils
import com.breezefsmpriyankaenterprises.app.utils.AppUtils.Companion.bitmapDescriptorFromVector
import com.breezefsmpriyankaenterprises.base.presentation.BaseFragment
import com.breezefsmpriyankaenterprises.features.location.LocationWizard
import com.breezefsmpriyankaenterprises.features.location.SingleShotLocationProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.pnikosis.materialishprogress.ProgressWheel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.function.Function
import java.util.stream.Collectors
import kotlin.math.max
import kotlin.math.min


class ShopDtlsMarketAssistFrag : BaseFragment(), View.OnClickListener, OnMapReadyCallback {

    private lateinit var mContext: Context

    private lateinit var progress_wheel:ProgressWheel

    private lateinit var shopNameTV: TextView
    private lateinit var avgOrdValueTV: TextView

    private lateinit var prodNameMaxVal: TextView
    private lateinit var prodNameMaxAmt: TextView
    private lateinit var prodNameMinVal: TextView
    private lateinit var prodNameMinAmt: TextView

    private lateinit var prodNameMaxQty: TextView
    private lateinit var prodNameMaxQtyAmt: TextView
    private lateinit var prodNameMinQty: TextView
    private lateinit var prodNameMinQtyAmt: TextView

    private lateinit var lastVisitDateTV: TextView
    private lateinit var lastVisitTimeTV: TextView
    private lateinit var avgVisitTimeTV: TextView

    private lateinit var distanceTV: TextView
    private lateinit var mapDirectionCV: CardView

    private lateinit var rvProductSuggest: RecyclerView
    private lateinit var rvProductCross: RecyclerView

    var mapFragment: SupportMapFragment? = null
    private var mapCustomer: GoogleMap? = null

    var marksAddr: ArrayList<LatLng?> = ArrayList()
    var currentLat: String = ""
    var currentLong: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        var shopObj: ShopDtls = ShopDtls()
        fun getInstance(objects: Any): ShopDtlsMarketAssistFrag {
            val frag = ShopDtlsMarketAssistFrag()
            shopObj = objects as ShopDtls
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_shop_dtls_market_assist, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        progress_wheel = view.findViewById(R.id.progress_wheel_frag_shop_dtls_ma)
        progress_wheel.stopSpinning()

        shopNameTV = view.findViewById(R.id.tv_frag_shop_dtls_shop_name)
        avgOrdValueTV = view.findViewById(R.id.tv_frag_shop_dtls_avg_ord_amt)
        rvProductSuggest = view.findViewById(R.id.rv_ma_suggest_product)
        rvProductCross = view.findViewById(R.id.rv_ma_cross_product)

        prodNameMaxVal = view.findViewById(R.id.tv_product_ord_by_val_max_name)
        prodNameMaxAmt = view.findViewById(R.id.tv_product_ord_by_val_max_val)
        prodNameMinVal = view.findViewById(R.id.tv_product_ord_by_val_min_name)
        prodNameMinAmt = view.findViewById(R.id.tv_product_ord_by_val_min_val)

        prodNameMaxQty = view.findViewById(R.id.tv_product_ord_by_qty_max_name)
        prodNameMaxQtyAmt = view.findViewById(R.id.tv_product_ord_by_qty_max_amt)
        prodNameMinQty = view.findViewById(R.id.tv_product_ord_by_qty_min_name)
        prodNameMinQtyAmt = view.findViewById(R.id.tv_product_ord_by_qty_min_amt)

        lastVisitDateTV = view.findViewById(R.id.tv_frag_shop_dtls_ma_last_visit_date)
        lastVisitTimeTV = view.findViewById(R.id.tv_frag_shop_dtls_ma_last_visit_time)
        avgVisitTimeTV = view.findViewById(R.id.tv_frag_shop_dtls_ma_avg_visit_time)

        distanceTV = view.findViewById(R.id.tv_frag_shop_dtls_ma_dist)
        mapDirectionCV = view.findViewById(R.id.iv_frag_shop_dtls_ma_map_direction)

        mapDirectionCV.setOnClickListener(this)

        mapFragment =
            childFragmentManager.findFragmentById(R.id.map_frag_shop_dtls_ma) as SupportMapFragment

        getCurrentLoc()
    }

    fun getCurrentLoc() {
        progress_wheel.spin()
        SingleShotLocationProvider.requestSingleUpdate(mContext,
            object : SingleShotLocationProvider.LocationCallback {
                override fun onStatusChanged(status: String) {
                }

                override fun onProviderEnabled(status: String) {
                }

                override fun onProviderDisabled(status: String) {
                }

                override fun onNewLocationAvailable(location: Location) {
                    currentLat = location.latitude.toString()
                    currentLong = location.longitude.toString()
                    progress_wheel.stopSpinning()
                    setData()
                }
            })
    }

    private fun setData() {
        try {
            shopNameTV.text = shopObj.shop_name
            avgOrdValueTV.text = String.format("%.2f", AppDatabase.getDBInstance()!!.orderDetailsListDao().getAvgOrderValue(shopObj.shop_id).toDouble())
            doAsync {
                progress_wheel.spin()
                var allProeuctL: ArrayList<SuggestiveProduct> =
                    AppDatabase.getDBInstance()!!.orderDetailsListDao()
                        .getSuggestProductAll(shopObj.shop_id!!) as ArrayList<SuggestiveProduct>
                var distinctProductID = allProeuctL.distinctBy { it.product_id }
                    .map { it.product_id } as ArrayList<String>
                var productValueQtySumL: ArrayList<PurchasedProductTotal> = ArrayList()
                for (i in 0..distinctProductID.size - 1) {
                    var qtyTotal =
                        allProeuctL.filter { it.product_id.equals(distinctProductID.get(i)) }
                            .map { it.qty.toDouble() }.sum()
                    var amtTotal =
                        allProeuctL.filter { it.product_id.equals(distinctProductID.get(i)) }
                            .map { it.total_price.toDouble() }.sum()

                    var obj: PurchasedProductTotal = PurchasedProductTotal()
                    obj.product_id = distinctProductID.get(i)
                    obj.product_name =
                        allProeuctL.filter { it.product_id.equals(distinctProductID.get(i)) }
                            .first().product_name
                    obj.totalValue = amtTotal.toString()
                    obj.totalQty = qtyTotal.toString()
                    productValueQtySumL.add(obj)
                }
                uiThread {
                    var minValueObj = productValueQtySumL.minByOrNull { it.totalValue.toDouble() }
                    var maxValueObj = productValueQtySumL.maxByOrNull { it.totalValue.toDouble() }
                    var minQtyObj = productValueQtySumL.minByOrNull { it.totalQty.toDouble() }
                    var maxQtyObj = productValueQtySumL.maxByOrNull { it.totalQty.toDouble() }

                    prodNameMaxVal.text = maxValueObj!!.product_name
                    prodNameMaxAmt.text = resources.getString(R.string.rupee_symbol_with_space) + " " + String.format("%.02f",maxValueObj!!.totalValue.toDouble())
                    prodNameMinVal.text = minValueObj!!.product_name
                    prodNameMinAmt.text = resources.getString(R.string.rupee_symbol_with_space) + " " + String.format("%.02f",minValueObj!!.totalValue.toDouble())

                    prodNameMaxVal.isSelected = true
                    prodNameMaxAmt.isSelected = true
                    prodNameMinVal.isSelected = true
                    prodNameMinAmt.isSelected = true

                    prodNameMaxQty.text = maxQtyObj!!.product_name
                    prodNameMaxQtyAmt.text = maxQtyObj!!.totalQty + " PCS"
                    prodNameMinQty.text = minQtyObj!!.product_name
                    prodNameMinQtyAmt.text = minQtyObj!!.totalQty + " PCS"

                    prodNameMaxQty.isSelected = true
                    prodNameMaxQtyAmt.isSelected = true
                    prodNameMinQty.isSelected = true
                    prodNameMinQtyAmt.isSelected = true
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.stopSpinning()
        }

        try {
            var lastVisitRecord =
                AppDatabase.getDBInstance()!!.shopActivityDao().getLastRow(shopObj.shop_id)
            var lastVisitDate = lastVisitRecord.visited_date!!.replace("T", " ").split(" ").get(0)
            lastVisitDateTV.text =
                "Date : " + AppUtils.getFormatedDateNew(lastVisitDate, "yyyy-mm-dd", "dd-mm-yyyy")!!
                    .replace("-", "/") + " " + AppUtils.getDayName(lastVisitDate)
            lastVisitTimeTV.text =
                "Time : " + AppUtils.getMeredianTimeFromISODateTime(lastVisitRecord.visited_date!!)
            var shopActivityL30Days: ArrayList<ShopActivityEntity> =
                AppDatabase.getDBInstance()!!.shopActivityDao()
                    .getShopActivity(shopObj.shop_id) as ArrayList<ShopActivityEntity>
            var durationL: ArrayList<String> =
                shopActivityL30Days.map { it.duration_spent } as ArrayList<String>
            var hrTotal = 0
            var minTotal = 0
            var secTotal = 0
            for (i in 0..durationL.size - 1) {
                var obj = durationL.get(i)
                hrTotal = hrTotal + obj.split(":").get(0).toInt()
                minTotal = minTotal + obj.split(":").get(1).toInt()
                secTotal = secTotal + obj.split(":").get(2).toInt()
            }
            if (secTotal > 60) {
                minTotal = minTotal + secTotal / 60
                secTotal = secTotal % 60
            }
            if (minTotal > 60) {
                hrTotal = hrTotal + minTotal / 60
                minTotal = minTotal % 60
            }

            var totalAvgTimeInSec =
                ((hrTotal * 60 * 60) + (minTotal * 60) + secTotal) / durationL.size
            var avgSec = totalAvgTimeInSec % 60
            var avgMin = totalAvgTimeInSec / 60
            var avgHr = avgMin / 60
            avgMin = avgMin % 60

            var avgDuration: String = ""
            if (avgHr == 0) {
                avgDuration =
                    avgMin.toInt().toString() + "mins " + avgSec.toInt().toString() + "secs"
            } else {
                avgDuration = avgHr.toInt().toString() + "hrs " + avgMin.toInt()
                    .toString() + "mins " + avgSec.toInt().toString() + "secs"
            }
            avgVisitTimeTV.text = avgDuration

        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.stopSpinning()
        }

        marksAddr = ArrayList()
        marksAddr.add(LatLng(currentLat.toDouble(), currentLong.toDouble()))
        marksAddr.add(LatLng(shopObj.shopLat.toDouble(), shopObj.shopLong.toDouble()))
        var dist = LocationWizard.getDistance(currentLat.toDouble(), currentLong.toDouble(), shopObj.shopLat.toDouble(), shopObj.shopLong.toDouble())
        var kmDist = dist.toInt()
        var mDist = Math.round((dist - kmDist) * 1000).toInt()
        if(kmDist == 0){
            distanceTV.text = "Distance : $mDist mtr"
        }else{
            distanceTV.text = "Distance : $kmDist km $mDist mtr"
        }
        showMap()

        try {
            doAsync {
                var suggestProductL: ArrayList<SuggestiveProduct> = AppDatabase.getDBInstance()!!.orderDetailsListDao().getSuggestProduct(shopObj.shop_id!!) as ArrayList<SuggestiveProduct>
                var finalSuggestProductList: ArrayList<SuggestiveProductFinal> = ArrayList()

                var suggestProductLDistinctId = suggestProductL.distinctBy { it.product_id }
                var productOccuranceL: ArrayList<ProductOccur> = ArrayList()
                for (i in 0..suggestProductLDistinctId.size - 1) {
                    var proID = suggestProductLDistinctId.get(i).product_id
                    productOccuranceL.add(
                        ProductOccur(
                            proID,
                            suggestProductL.count { it.product_id == proID })
                    )
                }
                productOccuranceL = ArrayList(productOccuranceL).sortedWith(compareBy { it.occur }).reversed() as ArrayList<ProductOccur>

                for (i in 0..productOccuranceL.size - 1) {
                    var objL = suggestProductL.filter { it.product_id.equals(productOccuranceL.get(i).product_id) } as ArrayList<SuggestiveProduct>
                    var totalOrdValue = 0.0
                    var totalOrdQty = 0.0
                    for (j in 0..objL.size - 1) {
                        totalOrdValue = totalOrdValue + objL.get(j).total_price.toDouble()
                        totalOrdQty = totalOrdQty + objL.get(j).qty.toDouble()
                    }
                    finalSuggestProductList.add(SuggestiveProductFinal(
                            objL.get(0).product_id,
                            objL.get(0).product_name,
                            String.format("%.02f", (totalOrdValue / totalOrdQty).toDouble()),
                            String.format("%.02f", (totalOrdQty / objL.size).toDouble())
                        )
                    )
                    if (i == 4) {
                        break
                    }
                }
                uiThread {
                    rvProductSuggest.adapter = AdapterSuggestiveProduct(mContext, finalSuggestProductList)
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.stopSpinning()
        }

        //code for cross sell
        try {
            doAsync {
                var suggestProductL: ArrayList<SuggestiveProduct> = AppDatabase.getDBInstance()!!.orderDetailsListDao().getSuggestProduct(shopObj.shop_id!!) as ArrayList<SuggestiveProduct>
                var finalSuggestProductList: ArrayList<SuggestiveProductFinal> = ArrayList()
                println("tag_ma $suggestProductL")
                var suggestProductLDistinctId = suggestProductL.distinctBy { it.product_id }
                var productQtyL: ArrayList<ProductOccur> = ArrayList()
                var productOccuranceL: ArrayList<ProductOccur> = ArrayList()
                for (i in 0..suggestProductLDistinctId.size - 1) {
                    var proID = suggestProductLDistinctId.get(i).product_id
                    var totalQty = suggestProductL.filter { it.product_id.equals(proID) }.map { it.qty.toDouble() }.sum()
                    productOccuranceL.add(ProductOccur(proID, suggestProductL.count { it.product_id == proID },totalQty.toString()))
                }
                productOccuranceL = ArrayList(productOccuranceL).sortedWith(compareBy { it.totalQty.toDouble() }).reversed().reversed() as ArrayList<ProductOccur>
                println("tag_ma $productOccuranceL")

                for (i in 0..productOccuranceL.size - 1) {
                    println("tag_ma $i")
                    var objL = suggestProductL.filter { it.product_id.equals(productOccuranceL.get(i).product_id) } as ArrayList<SuggestiveProduct>
                    var totalOrdValue = 0.0
                    var totalOrdQty = 0.0
                    for (j in 0..objL.size - 1) {
                        totalOrdValue = totalOrdValue + objL.get(j).total_price.toDouble()
                        totalOrdQty = totalOrdQty + objL.get(j).qty.toDouble()
                    }
                    finalSuggestProductList.add(SuggestiveProductFinal(
                        objL.get(0).product_id,
                        objL.get(0).product_name,
                        String.format("%.02f", (totalOrdValue / totalOrdQty).toDouble()),
                        String.format("%.02f", (totalOrdQty / objL.size).toDouble())
                    )
                    )
                    if (i == 4) {
                        break
                    }
                }
                uiThread {
                    rvProductCross.adapter = AdapterCrossSellProduct(mContext, finalSuggestProductList)
                    progress_wheel.stopSpinning()
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            progress_wheel.stopSpinning()
        }


    }

    private fun showMap() {
        mapFragment!!.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mapCustomer = googleMap
        for (i in 0..marksAddr.size - 1) {
            if (i == 0) {
                /*val mark = marksAddr[i]
                mapCustomer!!.addMarker(
                    MarkerOptions()
                    .position(mark!!)
                    .icon(bitmapDescriptorFromVector(mContext, R.drawable.scooter_man))
                    .title("Your Location"))
                mapCustomer!!.moveCamera(CameraUpdateFactory.newLatLng(mark))
                mapCustomer!!.animateCamera(CameraUpdateFactory.zoomTo(14f))*/
            } else if (i == marksAddr.size - 1) {
                val mark = marksAddr[i]
                mapCustomer!!.addMarker(
                    MarkerOptions()
                        .position(mark!!)
                        .icon(bitmapDescriptorFromVector(mContext, R.drawable.your_location))
                        .title("Shop Location")
                )
                mapCustomer!!.moveCamera(CameraUpdateFactory.newLatLng(mark))
                mapCustomer!!.animateCamera(CameraUpdateFactory.zoomTo(14f))
            }
        }

        val mark = marksAddr[0]
        mapCustomer!!.addMarker(
            MarkerOptions()
                .position(mark!!)
                .icon(bitmapDescriptorFromVector(mContext, R.drawable.scooter_man))
                .title("Your Location")
        )
        mapCustomer!!.moveCamera(CameraUpdateFactory.newLatLngZoom(marksAddr[0]!!, 15f))

        val opts = PolylineOptions().addAll(marksAddr).color(Color.GREEN).width(8f)
        mapCustomer!!.addPolyline(opts)
        mapCustomer!!.uiSettings.isZoomControlsEnabled = true
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.iv_frag_shop_dtls_ma_map_direction -> {
                try{
                    var intentGmap: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=${shopObj.shopLat},${shopObj.shopLong}&mode=1"))
                    intentGmap.setPackage("com.google.android.apps.maps")
                    if(intentGmap.resolveActivity(mContext!!.packageManager) !=null){
                        mContext!!.startActivity(intentGmap)
                    }
                }catch (ex:Exception){
                    ex.printStackTrace()
                }
            }
        }
    }
}