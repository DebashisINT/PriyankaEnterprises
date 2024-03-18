package com.fsmpriyankaenterprises.features.viewAllOrder.model

import com.fsmpriyankaenterprises.app.domain.NewOrderColorEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderProductEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderSizeEntity
import com.fsmpriyankaenterprises.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

