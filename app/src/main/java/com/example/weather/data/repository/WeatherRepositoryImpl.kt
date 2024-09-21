package com.example.weather.data.repository

import com.example.weather.data.mapper.toEntity
import com.example.weather.data.network.api.ApiService
import com.example.weather.domain.entity.Forecast
import com.example.weather.domain.entity.Weather
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(citiId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$citiId").toEntity()
    }

    override suspend fun getForecast(citiId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$citiId").toEntity()
    }

    private companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}