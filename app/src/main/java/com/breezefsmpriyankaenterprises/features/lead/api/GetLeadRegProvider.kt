package com.breezefsmpriyankaenterprises.features.lead.api

import com.breezefsmpriyankaenterprises.features.NewQuotation.api.GetQuotListRegRepository
import com.breezefsmpriyankaenterprises.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}