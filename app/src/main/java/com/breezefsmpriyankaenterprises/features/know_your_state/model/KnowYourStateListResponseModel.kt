package com.breezefsmpriyankaenterprises.features.know_your_state.model

import com.breezefsmpriyankaenterprises.base.BaseResponse
import java.io.Serializable

/**
 * Created by Saikat on 27-11-2019.
 */
class KnowYourStateListResponseModel: BaseResponse(), Serializable {
    var know_state_list: ArrayList<KnowYourStateListDataModel>? = null
}