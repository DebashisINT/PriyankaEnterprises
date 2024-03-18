package com.fsmpriyankaenterprises.features.viewAllOrder.interf

import com.fsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.fsmpriyankaenterprises.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}