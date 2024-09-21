package com.example.weather.data.repository

import com.example.weather.data.mapper.toEntities
import com.example.weather.data.network.api.ApiService
import com.example.weather.domain.entity.City
import com.example.weather.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SearchRepository {

    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}