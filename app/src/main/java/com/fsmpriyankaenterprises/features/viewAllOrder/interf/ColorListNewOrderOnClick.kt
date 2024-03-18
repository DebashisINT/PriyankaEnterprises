package com.fsmpriyankaenterprises.features.viewAllOrder.interf

import com.fsmpriyankaenterprises.app.domain.NewOrderColorEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}