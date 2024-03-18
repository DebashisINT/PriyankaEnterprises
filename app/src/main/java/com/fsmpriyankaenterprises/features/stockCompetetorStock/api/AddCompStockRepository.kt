package com.fsmpriyankaenterprises.features.stockCompetetorStock.api

import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.orderList.model.NewOrderListResponseModel
import com.fsmpriyankaenterprises.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.fsmpriyankaenterprises.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}