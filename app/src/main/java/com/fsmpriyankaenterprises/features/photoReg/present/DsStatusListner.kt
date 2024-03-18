package com.fsmpriyankaenterprises.features.photoReg.present

import com.fsmpriyankaenterprises.app.domain.ProspectEntity
import com.fsmpriyankaenterprises.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}