package com.breezefsmpriyankaenterprises.features.viewAllOrder.model

import com.breezefsmpriyankaenterprises.app.domain.NewOrderColorEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderProductEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderSizeEntity
import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

