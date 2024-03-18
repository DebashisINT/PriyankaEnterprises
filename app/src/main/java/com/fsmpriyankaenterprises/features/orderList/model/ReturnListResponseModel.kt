package com.fsmpriyankaenterprises.features.orderList.model

import com.fsmpriyankaenterprises.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}