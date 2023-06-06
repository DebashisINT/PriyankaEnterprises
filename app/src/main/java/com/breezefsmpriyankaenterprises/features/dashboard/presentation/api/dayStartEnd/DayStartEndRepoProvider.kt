package com.breezefsmpriyankaenterprises.features.dashboard.presentation.api.dayStartEnd

import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.api.AddCompStockApi
import com.breezefsmpriyankaenterprises.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}