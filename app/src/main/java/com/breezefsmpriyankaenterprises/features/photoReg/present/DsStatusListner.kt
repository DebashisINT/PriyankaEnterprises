package com.breezefsmpriyankaenterprises.features.photoReg.present

import com.breezefsmpriyankaenterprises.app.domain.ProspectEntity
import com.breezefsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}