package com.breezefsmpriyankaenterprises.features.marketAssist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.breezefsmpriyankaenterprises.R
import kotlinx.android.synthetic.main.row_suggest_product.view.ll_row_pro_sugg_root
import kotlinx.android.synthetic.main.row_suggest_product.view.tv_row_pro_sugg_name
import kotlinx.android.synthetic.main.row_suggest_product.view.tv_row_pro_sugg_qty
import kotlinx.android.synthetic.main.row_suggest_product.view.tv_row_pro_sugg_rate

class AdapterSuggestiveProduct(var mContext:Context,var mList:ArrayList<SuggestiveProductFinal>):
    RecyclerView.Adapter<AdapterSuggestiveProduct.SuggestiveProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestiveProductViewHolder {
        var v = LayoutInflater.from(mContext).inflate(R.layout.row_suggest_product,parent,false)
        return SuggestiveProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: SuggestiveProductViewHolder, position: Int) {
        holder.bindItems()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class SuggestiveProductViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun bindItems(){
            itemView.tv_row_pro_sugg_name.text = mList.get(adapterPosition).product_name
            itemView.tv_row_pro_sugg_rate.text = mList.get(adapterPosition).suggestiveOrdRate
            itemView.tv_row_pro_sugg_qty.text = mList.get(adapterPosition).suggestiveOrdQty

            if(adapterPosition%2 == 0){
                itemView.ll_row_pro_sugg_root.setBackgroundColor(ContextCompat.getColor(mContext, R.color.card_custom_back1))
                itemView.tv_row_pro_sugg_name.setTextColor(mContext.resources.getColor(R.color.black))
                itemView.tv_row_pro_sugg_rate.setTextColor(mContext.resources.getColor(R.color.black))
                itemView.tv_row_pro_sugg_qty.setTextColor(mContext.resources.getColor(R.color.black))
            }else{
                itemView.ll_row_pro_sugg_root.setBackgroundColor(ContextCompat.getColor(mContext, R.color.link_blue))
                itemView.tv_row_pro_sugg_name.setTextColor(mContext.resources.getColor(R.color.white))
                itemView.tv_row_pro_sugg_rate.setTextColor(mContext.resources.getColor(R.color.white))
                itemView.tv_row_pro_sugg_qty.setTextColor(mContext.resources.getColor(R.color.white))
            }
        }
    }

}