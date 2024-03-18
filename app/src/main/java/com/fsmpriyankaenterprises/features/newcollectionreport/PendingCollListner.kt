package com.fsmpriyankaenterprises.features.newcollectionreport

import com.fsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}