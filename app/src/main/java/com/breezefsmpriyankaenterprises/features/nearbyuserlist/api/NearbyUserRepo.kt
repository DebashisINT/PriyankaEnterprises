package com.breezefsmpriyankaenterprises.features.nearbyuserlist.api

import com.breezefsmpriyankaenterprises.app.Pref
import com.breezefsmpriyankaenterprises.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezefsmpriyankaenterprises.features.newcollection.model.NewCollectionListResponseModel
import com.breezefsmpriyankaenterprises.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}