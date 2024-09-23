package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.example.weather.WeatherApp
import com.example.weather.domain.usecase.ChangeFavoriteStateUseCase
import com.example.weather.domain.usecase.SearchCityUseCase
import com.example.weather.presentation.root.DefaultRootComponent
import com.example.weather.presentation.root.RootContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val component = rootComponentFactory.create(defaultComponentContext())
        setContent {
            RootContent(component = component)
        }
    }
}

