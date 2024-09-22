package com.example.weather.presentation.favorite

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.weather.domain.entity.City
import com.example.weather.presentation.extensions.componentScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DefaultFavoriteComponent @Inject constructor(
    private val favoriteStoreFactory: FavoriteStoreFactory,
    private val onCityItemClicked: (City) -> Unit,
    private val onAddFavoriteClicked: () -> Unit,
    private val onSearchClicked: () -> Unit,
    componentContext: ComponentContext
) : FavoriteComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        favoriteStoreFactory.create()
    }

    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is FavoriteStore.Label.CityItemClick -> {
                        onCityItemClicked(it.city)
                    }

                    FavoriteStore.Label.ClickSearch -> {
                        onSearchClicked()
                    }

                    FavoriteStore.Label.ClickToFavorite -> {
                        onAddFavoriteClicked()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<FavoriteStore.State> = store.stateFlow

    override fun onClickSearch() {
        store.accept(FavoriteStore.Intent.ClickSearch)
    }

    override fun onClickAddFavorite() {
        store.accept(FavoriteStore.Intent.ClickAddToFavorite)
    }

    override fun onCityItemCLick(city: City) {
        store.accept(FavoriteStore.Intent.CityItemClick(city))
    }
}