package com.example.weather.domain.repository

import com.example.weather.domain.entity.City
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    val favoriteCities: Flow<City>

    fun observeIsFavorite(citiId: Int): Flow<Boolean>

    suspend fun addToFavorite(city: City)

    suspend fun removeFromFavorite(citiId: Int)
}