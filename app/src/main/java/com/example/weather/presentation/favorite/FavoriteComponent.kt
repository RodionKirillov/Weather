package com.example.weather.presentation.favorite

import com.example.weather.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavoriteComponent {

    val model: StateFlow<FavoriteStore.State>

    fun onClickSearch()

    fun onClickAddFavorite()

    fun onCityItemCLick(city: City)
}