package com.fsmpriyankaenterprises.features.photoReg.adapter

import com.fsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface PhotoAttendanceListner {
    fun getUserInfoOnLick(obj: UserListResponseModel)
    fun getUserInfoAttendReportOnLick(obj: UserListResponseModel)
}