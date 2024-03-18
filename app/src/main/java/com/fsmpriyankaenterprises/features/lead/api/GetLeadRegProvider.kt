package com.fsmpriyankaenterprises.features.lead.api

import com.fsmpriyankaenterprises.features.NewQuotation.api.GetQuotListRegRepository
import com.fsmpriyankaenterprises.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}