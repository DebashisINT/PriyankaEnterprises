package com.breezefsmpriyankaenterprises.features.weather.api

import com.breezefsmpriyankaenterprises.features.task.api.TaskApi
import com.breezefsmpriyankaenterprises.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}