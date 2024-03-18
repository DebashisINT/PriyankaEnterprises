package com.fsmpriyankaenterprises.features.stockAddCurrentStock.api

import com.fsmpriyankaenterprises.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.fsmpriyankaenterprises.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}