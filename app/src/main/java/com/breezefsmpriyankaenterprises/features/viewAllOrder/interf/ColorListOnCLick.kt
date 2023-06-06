package com.breezefsmpriyankaenterprises.features.viewAllOrder.interf

import com.breezefsmpriyankaenterprises.app.domain.NewOrderGenderEntity
import com.breezefsmpriyankaenterprises.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}