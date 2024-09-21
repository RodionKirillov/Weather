package com.example.weather.domain.repository

import com.example.weather.domain.entity.Forecast
import com.example.weather.domain.entity.Weather


interface WeatherRepository {

    suspend fun getWeather(citiId: Int): Weather

    suspend fun getForecast(citiId: Int): Forecast
}