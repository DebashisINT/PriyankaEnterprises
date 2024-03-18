package com.fsmpriyankaenterprises.features.orderhistory.api

import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.orderhistory.model.LocationUpdateRequest
import io.reactivex.Observable

/**
 * Created by Pratishruti on 23-11-2017.
 */
class LocationUpdateRepository(val apiService:LocationUpdateApi) {
    fun sendLocationUpdate(location: LocationUpdateRequest): Observable<BaseResponse> {
        return apiService.sendLocationUpdates(location)
    }
}