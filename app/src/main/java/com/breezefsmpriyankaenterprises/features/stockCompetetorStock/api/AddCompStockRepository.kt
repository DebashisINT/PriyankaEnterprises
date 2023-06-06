package com.breezefsmpriyankaenterprises.features.stockCompetetorStock.api

import com.breezefsmpriyankaenterprises.base.BaseResponse
import com.breezefsmpriyankaenterprises.features.orderList.model.NewOrderListResponseModel
import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}