package com.example.weather.domain.repository

import com.example.weather.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}