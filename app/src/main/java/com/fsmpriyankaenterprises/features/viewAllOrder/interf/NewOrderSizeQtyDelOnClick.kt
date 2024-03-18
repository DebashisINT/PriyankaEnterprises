package com.fsmpriyankaenterprises.features.viewAllOrder.interf

import com.fsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.fsmpriyankaenterprises.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}