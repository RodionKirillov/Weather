package com.example.weather.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.weather.presentation.details.DefaultDetailsComponent
import com.example.weather.presentation.favorite.DefaultFavoriteComponent
import com.example.weather.presentation.search.DefaultSearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favorite(
            val component: DefaultFavoriteComponent
        ) : Child

        data class Search(
            val component: DefaultSearchComponent
        ) : Child

        data class Details(
            val component: DefaultDetailsComponent
        ) : Child
    }
}