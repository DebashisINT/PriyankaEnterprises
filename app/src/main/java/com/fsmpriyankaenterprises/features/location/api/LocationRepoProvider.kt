package com.fsmpriyankaenterprises.features.location.api

import com.fsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationApi
import com.fsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}