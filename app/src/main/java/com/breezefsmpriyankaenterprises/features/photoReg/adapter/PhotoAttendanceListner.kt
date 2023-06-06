package com.breezefsmpriyankaenterprises.features.photoReg.adapter

import com.breezefsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface PhotoAttendanceListner {
    fun getUserInfoOnLick(obj: UserListResponseModel)
    fun getUserInfoAttendReportOnLick(obj: UserListResponseModel)
}