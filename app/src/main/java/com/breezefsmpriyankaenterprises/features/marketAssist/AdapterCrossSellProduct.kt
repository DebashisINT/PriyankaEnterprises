package com.breezefsmpriyankaenterprises.features.marketAssist

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.breezefsmpriyankaenterprises.R
import kotlinx.android.synthetic.main.row_cross_sell_product.view.iv_row_pro_cross_name
import kotlinx.android.synthetic.main.row_cross_sell_product.view.tv_row_pro_cross_name
import kotlinx.android.synthetic.main.row_cross_sell_product.view.tv_row_pro_cross_qty
import kotlinx.android.synthetic.main.row_cross_sell_product.view.tv_row_pro_cross_rate

class AdapterCrossSellProduct(var mContext: Context, var mList:ArrayList<SuggestiveProductFinal>):
    RecyclerView.Adapter<AdapterCrossSellProduct.CrossSellProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrossSellProductViewHolder {
        var v = LayoutInflater.from(mContext).inflate(R.layout.row_cross_sell_product,parent,false)
        return CrossSellProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: CrossSellProductViewHolder, position: Int) {
        holder.bindItems()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class CrossSellProductViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        @SuppressLint("ResourceType")
        fun bindItems(){
            itemView.tv_row_pro_cross_name.text = mList.get(adapterPosition).product_name
            itemView.tv_row_pro_cross_rate.text = mList.get(adapterPosition).suggestiveOrdRate
            itemView.tv_row_pro_cross_qty.text = mList.get(adapterPosition).suggestiveOrdQty

            itemView.tv_row_pro_cross_name.isSelected = true

            /*if(adapterPosition == 0){
                itemView.iv_row_pro_cross_name.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.color_custom_green_light))
            }else if(adapterPosition == 1 ){
                itemView.iv_row_pro_cross_name.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.color_blue_light_dark))
            }else if(adapterPosition == 2 ){
                itemView.iv_row_pro_cross_name.setBackgroundTintList(mContext.getResources().getColorStateList(Color.parseColor("#c6880f")))
            }else if(adapterPosition == 3 ){
                itemView.iv_row_pro_cross_name.setBackgroundTintList(mContext.getResources().getColorStateList(Color.parseColor("#c6880f")))
            }*/
        }
    }

}