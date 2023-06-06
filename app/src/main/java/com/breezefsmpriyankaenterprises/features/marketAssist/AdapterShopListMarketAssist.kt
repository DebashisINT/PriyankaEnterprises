package com.breezefsmpriyankaenterprises.features.marketAssist

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.breezefsmpriyankaenterprises.R
import com.breezefsmpriyankaenterprises.app.types.FragType
import com.breezefsmpriyankaenterprises.features.dashboard.presentation.DashboardActivity
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.cv_row_shop_list_ma_beat_root
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.ll_row_shop_list_ma_assist
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_addr
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_name
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_name_pref
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_shop_beat
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_shop_contact
import kotlinx.android.synthetic.main.row_shop_list_market_assist.view.tv_row_shop_list_ma_shop_type
import java.util.Random

class AdapterShopListMarketAssist(var mContext:Context,var mList:ArrayList<ShopDtls>):
RecyclerView.Adapter<AdapterShopListMarketAssist.ShopListMarketAssistViewHolder>(){

    private lateinit var colorCodeL : ArrayList<String>
    val random = Random()
    init {
        colorCodeL= ArrayList()
        colorCodeL.add("#0FB9F0")
        colorCodeL.add("#AA33AA")
        colorCodeL.add("#3E2CF1")
        colorCodeL.add("#45560F")
        colorCodeL.add("#DF6714")
        colorCodeL.add("#540422")
        colorCodeL.add("#04544A")
        colorCodeL.add("#958609")
        colorCodeL.add("#283747")
        colorCodeL.add("#1B4F72")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListMarketAssistViewHolder {
        var v = LayoutInflater.from(mContext).inflate(R.layout.row_shop_list_market_assist,parent,false)
        return ShopListMarketAssistViewHolder(v)
    }

    override fun onBindViewHolder(holder: ShopListMarketAssistViewHolder, position: Int) {
        holder.bindItems()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ShopListMarketAssistViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun bindItems(){
            val m = random.nextInt(9 - 1) + 1
            itemView.tv_row_shop_list_ma_name_pref.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorCodeL.get(m))))

            itemView.tv_row_shop_list_ma_name_pref.text = mList.get(adapterPosition).shop_name.get(0).toString()
            itemView.tv_row_shop_list_ma_name.text = mList.get(adapterPosition).shop_name
            itemView.tv_row_shop_list_ma_addr.text = mList.get(adapterPosition).address
            itemView.tv_row_shop_list_ma_shop_type.text = mList.get(adapterPosition).shopType
            itemView.tv_row_shop_list_ma_shop_contact.text = mList.get(adapterPosition).owner_contact_number
            if(mList.get(adapterPosition).beatName.equals("")){
                itemView.cv_row_shop_list_ma_beat_root.visibility = View.GONE
            }else{
                itemView.cv_row_shop_list_ma_beat_root.visibility = View.VISIBLE
                itemView.tv_row_shop_list_ma_shop_beat.text = mList.get(adapterPosition).beatName
            }


            itemView.ll_row_shop_list_ma_assist.setOnClickListener {
                (mContext as DashboardActivity).loadFragment(FragType.ShopDtlsMarketAssistFrag, true, mList.get(adapterPosition))
            }
        }
    }

}