package com.fsmpriyankaenterprises.features.login.model.productlistmodel

import com.fsmpriyankaenterprises.app.domain.NewOrderScrOrderEntity
import com.fsmpriyankaenterprises.app.domain.ProductListEntity

class NewOdrScrOrderListModel {
    var status:String? = null
    var message:String? = null
    var user_id:String? = null
    var order_list: ArrayList<NewOrderScrOrderEntity>? = null
}