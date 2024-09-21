package com.example.weather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weather.data.network.api.ApiFactory
import com.example.weather.data.network.api.ApiService
import com.example.weather.presentation.ui.theme.WeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val apiService = ApiFactory.apiService
        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("London")
            val forecastWeather = apiService.loadForecast("London")
            val cities = apiService.searchCity("London")
            Log.d("LOG_TAG", "currentWeather: $currentWeather")
            Log.d("LOG_TAG", "forecastWeather: $forecastWeather")
            Log.d("LOG_TAG", "cities: $cities")
        }
        setContent {
            WeatherTheme {

            }
        }
    }
}

