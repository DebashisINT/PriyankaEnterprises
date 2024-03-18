package com.fsmpriyankaenterprises.features.addAttendence.api

import com.fsmpriyankaenterprises.app.Pref
import com.fsmpriyankaenterprises.features.addAttendence.model.WorkTypeResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 31-08-2018.
 */
class WorkTypeListRepo(val apiService: WorkTypeListApi) {
    fun getWorkTypeList(): Observable<WorkTypeResponseModel> {
        return apiService.getWorkType(Pref.user_id!!)
    }
}