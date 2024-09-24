package com.example.weather.domain.usecase

import com.example.weather.domain.entity.City
import com.example.weather.domain.repository.FavoriteRepository
import javax.inject.Inject

class ChangeFavoriteStateUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun addToFavorite(city: City) = favoriteRepository.addToFavorite(city)

    suspend fun removeFromFavorite(citiId: Int) = favoriteRepository.removeFromFavorite(citiId)
}