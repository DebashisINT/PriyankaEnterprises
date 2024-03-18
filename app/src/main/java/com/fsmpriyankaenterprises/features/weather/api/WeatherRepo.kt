package com.fsmpriyankaenterprises.features.weather.api

import com.fsmpriyankaenterprises.base.BaseResponse
import com.fsmpriyankaenterprises.features.task.api.TaskApi
import com.fsmpriyankaenterprises.features.task.model.AddTaskInputModel
import com.fsmpriyankaenterprises.features.weather.model.ForeCastAPIResponse
import com.fsmpriyankaenterprises.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}