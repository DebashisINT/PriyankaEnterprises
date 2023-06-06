package com.breezefsmpriyankaenterprises.features.viewAllOrder.interf

import com.breezefsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.breezefsmpriyankaenterprises.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}