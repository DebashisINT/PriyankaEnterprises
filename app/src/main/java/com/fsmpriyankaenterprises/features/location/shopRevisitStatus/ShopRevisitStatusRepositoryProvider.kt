package com.fsmpriyankaenterprises.features.location.shopRevisitStatus

import com.fsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationApi
import com.fsmpriyankaenterprises.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}