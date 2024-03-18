package com.fsmpriyankaenterprises.features.newcollection.model

import com.fsmpriyankaenterprises.app.domain.CollectionDetailsEntity
import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}