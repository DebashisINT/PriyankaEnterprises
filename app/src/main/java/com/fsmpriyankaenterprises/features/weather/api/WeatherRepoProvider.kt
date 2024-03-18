package com.fsmpriyankaenterprises.features.weather.api

import com.fsmpriyankaenterprises.features.task.api.TaskApi
import com.fsmpriyankaenterprises.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}