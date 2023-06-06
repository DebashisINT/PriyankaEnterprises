package com.breezefsmpriyankaenterprises.features.weather.api

import com.breezefsmpriyankaenterprises.base.BaseResponse
import com.breezefsmpriyankaenterprises.features.task.api.TaskApi
import com.breezefsmpriyankaenterprises.features.task.model.AddTaskInputModel
import com.breezefsmpriyankaenterprises.features.weather.model.ForeCastAPIResponse
import com.breezefsmpriyankaenterprises.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}