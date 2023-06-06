package com.breezefsmpriyankaenterprises.features.marketAssist

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.breezefsmpriyankaenterprises.R
import com.breezefsmpriyankaenterprises.app.AppDatabase
import com.breezefsmpriyankaenterprises.app.SearchListener
import com.breezefsmpriyankaenterprises.app.utils.AppUtils
import com.breezefsmpriyankaenterprises.app.utils.Toaster
import com.breezefsmpriyankaenterprises.base.presentation.BaseFragment
import com.breezefsmpriyankaenterprises.features.dashboard.presentation.DashboardActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.lang.Exception

class ShopListMarketAssistFrag : BaseFragment(), View.OnClickListener{

    private lateinit var mContext: Context
    private lateinit var rvShopList:RecyclerView
    private lateinit var etSearchShop:EditText
    private lateinit var llSearch:LinearLayout

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.frag_shop_list_market_assist, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        rvShopList = view.findViewById(R.id.rv_frag_shop_list_ma_list)
        etSearchShop = view.findViewById(R.id.et_frag_shop_list_ma_list_search)
        llSearch = view.findViewById(R.id.ll_frag_shop_list_ma_list_search)
        llSearch.setOnClickListener(this)


        setShopData("")
        etSearchShop.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().length == 0) {
                    AppUtils.hideSoftKeyboard(mContext as DashboardActivity)
                    setShopData("")
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    private fun setShopData(filter:String){
        var shopL : ArrayList<ShopDtls> = ArrayList()
        try{
            doAsync {
                if(filter.length==0){
                    shopL = AppDatabase.getDBInstance()?.addShopEntryDao()?.getShopForMarketAssist() as ArrayList<ShopDtls>
                }else{
                    shopL = AppDatabase.getDBInstance()?.addShopEntryDao()?.getShopForMarketAssist()!!.filter { it.shop_name.contains(filter,ignoreCase = true) || it.owner_contact_number.contains(filter) } as ArrayList<ShopDtls>
                }
                uiThread {
                    rvShopList.adapter = AdapterShopListMarketAssist(mContext,shopL)
                }
            }
        }catch (ex:Exception){
            ex.printStackTrace()
            Toaster.msgShort(mContext,"No data found.")
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ll_frag_shop_list_ma_list_search ->{
                var searchText = etSearchShop.text.toString()
                if(searchText.length>0){
                    AppUtils.hideSoftKeyboard(mContext as DashboardActivity)
                    setShopData(searchText)
                }
            }
        }
    }
}