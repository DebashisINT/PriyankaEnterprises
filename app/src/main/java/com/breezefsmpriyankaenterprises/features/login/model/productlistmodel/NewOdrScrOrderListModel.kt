package com.breezefsmpriyankaenterprises.features.login.model.productlistmodel

import com.breezefsmpriyankaenterprises.app.domain.NewOrderScrOrderEntity
import com.breezefsmpriyankaenterprises.app.domain.ProductListEntity

class NewOdrScrOrderListModel {
    var status:String? = null
    var message:String? = null
    var user_id:String? = null
    var order_list: ArrayList<NewOrderScrOrderEntity>? = null
}