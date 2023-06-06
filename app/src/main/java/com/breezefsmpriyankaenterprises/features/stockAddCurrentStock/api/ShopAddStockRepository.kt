package com.breezefsmpriyankaenterprises.features.stockAddCurrentStock.api

import com.breezefsmpriyankaenterprises.base.BaseResponse
import com.breezefsmpriyankaenterprises.features.location.model.ShopRevisitStatusRequest
import com.breezefsmpriyankaenterprises.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezefsmpriyankaenterprises.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.breezefsmpriyankaenterprises.features.stockAddCurrentStock.model.CurrentStockGetData
import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}