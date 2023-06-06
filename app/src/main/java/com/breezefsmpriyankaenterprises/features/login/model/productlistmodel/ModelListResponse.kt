package com.breezefsmpriyankaenterprises.features.login.model.productlistmodel

import com.breezefsmpriyankaenterprises.app.domain.ModelEntity
import com.breezefsmpriyankaenterprises.app.domain.ProductListEntity
import com.breezefsmpriyankaenterprises.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}