package com.breezefsmpriyankaenterprises.features.document.api

import com.breezefsmpriyankaenterprises.features.dymanicSection.api.DynamicApi
import com.breezefsmpriyankaenterprises.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}