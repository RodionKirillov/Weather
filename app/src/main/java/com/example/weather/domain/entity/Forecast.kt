package com.example.weather.domain.entity

data class Forecast(
    val currentWeather: Weather,
    val upcoming: List<Weather>
)
