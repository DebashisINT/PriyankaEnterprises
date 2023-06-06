package com.breezefsmpriyankaenterprises.features.viewAllOrder.interf

import com.breezefsmpriyankaenterprises.app.domain.NewOrderProductEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}