package com.fsmpriyankaenterprises.features.nearbyuserlist.api

import com.fsmpriyankaenterprises.app.Pref
import com.fsmpriyankaenterprises.features.nearbyuserlist.model.NearbyUserResponseModel
import com.fsmpriyankaenterprises.features.newcollection.model.NewCollectionListResponseModel
import com.fsmpriyankaenterprises.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}