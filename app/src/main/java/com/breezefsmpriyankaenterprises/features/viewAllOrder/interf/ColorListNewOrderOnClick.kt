package com.breezefsmpriyankaenterprises.features.viewAllOrder.interf

import com.breezefsmpriyankaenterprises.app.domain.NewOrderColorEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}