package com.fsmpriyankaenterprises.features.dashboard.presentation.api.submithomeloc

import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.dashboard.presentation.model.SubmitHomeLocationInputModel
import io.reactivex.Observable

/**
 * Created by Saikat on 13-03-2019.
 */
class SubmitHomeLocationRepo(val apiService: SubmitHomeLocationApi) {
    fun submitAttendance(addAttendenceModel: SubmitHomeLocationInputModel): Observable<BaseResponse> {
        return apiService.submitHomeLocation(addAttendenceModel)
    }
}