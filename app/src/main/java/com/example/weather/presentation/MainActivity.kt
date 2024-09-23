package com.example.weather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.example.weather.WeatherApp
import com.example.weather.data.network.api.ApiFactory
import com.example.weather.data.network.api.ApiService
import com.example.weather.presentation.root.DefaultRootComponent
import com.example.weather.presentation.root.RootContent
import com.example.weather.presentation.ui.theme.WeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
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

