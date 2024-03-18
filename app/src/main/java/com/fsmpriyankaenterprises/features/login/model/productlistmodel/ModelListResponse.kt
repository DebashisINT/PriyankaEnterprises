package com.fsmpriyankaenterprises.features.login.model.productlistmodel

import com.fsmpriyankaenterprises.app.domain.ModelEntity
import com.fsmpriyankaenterprises.app.domain.ProductListEntity
import com.fsmpriyankaenterprises.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}