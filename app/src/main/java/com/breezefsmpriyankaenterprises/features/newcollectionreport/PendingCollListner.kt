package com.breezefsmpriyankaenterprises.features.newcollectionreport

import com.breezefsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}