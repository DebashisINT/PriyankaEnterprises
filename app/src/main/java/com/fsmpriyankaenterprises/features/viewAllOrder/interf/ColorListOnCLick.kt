package com.fsmpriyankaenterprises.features.viewAllOrder.interf

import com.fsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.fsmpriyankaenterprises.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}