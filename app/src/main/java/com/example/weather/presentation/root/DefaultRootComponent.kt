package com.example.weather.presentation.root

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.weather.domain.entity.City
import com.example.weather.presentation.details.DefaultDetailsComponent
import com.example.weather.presentation.details.DefaultDetailsComponent_Factory
import com.example.weather.presentation.favorite.DefaultFavoriteComponent
import com.example.weather.presentation.search.DefaultSearchComponent
import com.example.weather.presentation.search.OpenReason
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class DefaultRootComponent @AssistedInject constructor(
    private val detailsComponentFactory: DefaultDetailsComponent.Factory,
    private val favoriteComponentFactory: DefaultFavoriteComponent.Factory,
    private val searchComponentFactory: DefaultSearchComponent.Factory,
    @Assisted("componentContext") componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = TODO("Not yet implemented")

    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (config) {
            is Config.Details -> {
                val component = detailsComponentFactory.create(
                    city = config.city,
                    onBackClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Details(component)
            }

            is Config.Favorite -> {
                val component = favoriteComponentFactory.create(
                    onCityItemClicked = {

                    },
                    onAddFavoriteClicked = {

                    },
                    onSearchClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Favorite(component)
            }

            is Config.Search -> {
                val component = searchComponentFactory.create(
                    openReason = config.openReason,
                    onBackClicked = {

                    },
                    onCitySavedToFavorite = {

                    },
                    onForecastForCityRequested = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Search(component)
            }
        }
    }

    sealed interface Config : Parcelable {

        @Parcelize
        data object Favorite : Config

        @Parcelize
        data class Search(
            val openReason: OpenReason
        ) : Config

        @Parcelize
        data class Details(
            val city: City
        ) : Config
    }

    @AssistedFactory
    interface Factory {

        fun create(
            @Assisted("componentContext") componentContext: ComponentContext
        ): DefaultRootComponent
    }
}