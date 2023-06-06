package com.breezefsmpriyankaenterprises.features.location.shopRevisitStatus

import com.breezefsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationApi
import com.breezefsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}