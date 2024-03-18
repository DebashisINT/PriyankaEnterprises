package com.fsmpriyankaenterprises.features.viewAllOrder.orderOptimized

import com.fsmpriyankaenterprises.app.domain.ProductOnlineRateTempEntity
import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}