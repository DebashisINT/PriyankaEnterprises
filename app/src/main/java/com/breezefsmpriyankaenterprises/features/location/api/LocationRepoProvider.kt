package com.breezefsmpriyankaenterprises.features.location.api

import com.breezefsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationApi
import com.breezefsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}