package com.fsmpriyankaenterprises.features.document.api

import com.fsmpriyankaenterprises.features.dymanicSection.api.DynamicApi
import com.fsmpriyankaenterprises.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}