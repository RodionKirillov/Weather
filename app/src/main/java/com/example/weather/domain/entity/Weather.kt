package com.example.weather.domain.entity

import java.util.Calendar

data class Weather(
    val tempC: Float,
    val conditionText: String,
    val conditionalUrl: String,
    val date: Calendar
)
