package com.example.weather.domain.usecase

import com.example.weather.domain.repository.FavoriteRepository
import javax.inject.Inject

class GetFavoriteCitiesUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {

    operator fun invoke() = favoriteRepository.favoriteCities
}