package com.breezefsmpriyankaenterprises.features.viewAllOrder.orderOptimized

import com.breezefsmpriyankaenterprises.app.domain.ProductOnlineRateTempEntity
import com.breezefsmpriyankaenterprises.base.BaseResponse
import com.breezefsmpriyankaenterprises.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}