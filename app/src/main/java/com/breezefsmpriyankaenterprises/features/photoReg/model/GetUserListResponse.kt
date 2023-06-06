package com.breezefsmpriyankaenterprises.features.photoReg.model

import com.breezefsmpriyankaenterprises.features.stockAddCurrentStock.model.CurrentStockGetDataDtls

class GetUserListResponse {
    var status:String ? = null
    var message:String ? = null
    var user_list :ArrayList<UserListResponseModel>? = null
}