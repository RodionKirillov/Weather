package com.example.weather.domain.usecase

import com.example.weather.domain.repository.FavoriteRepository
import javax.inject.Inject

class ObserveFavoriteStateUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {

    operator fun invoke(citiId: Int) = favoriteRepository.observeIsFavorite(citiId)
}