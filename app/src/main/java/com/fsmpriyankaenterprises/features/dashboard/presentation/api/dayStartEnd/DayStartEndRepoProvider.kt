package com.fsmpriyankaenterprises.features.dashboard.presentation.api.dayStartEnd

import com.fsmpriyankaenterprises.features.stockCompetetorStock.api.AddCompStockApi
import com.fsmpriyankaenterprises.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}