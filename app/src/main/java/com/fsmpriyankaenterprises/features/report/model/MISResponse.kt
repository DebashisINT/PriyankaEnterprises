package com.fsmpriyankaenterprises.features.report.model

import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.nearbyshops.model.ShopData

/**
 * Created by Pratishruti on 27-12-2017.
 */
class MISResponse:BaseResponse() {
    var shop_list:List<ShopData>? = null
    var shop_list_count:MISShopListCount?=null
}