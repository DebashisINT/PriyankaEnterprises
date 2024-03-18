package com.fsmpriyankaenterprises.features.viewAllOrder.interf

import com.fsmpriyankaenterprises.app.domain.NewOrderProductEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}