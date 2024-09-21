package com.example.weather.di

import android.content.Context
import com.example.weather.data.local.db.FavoriteCitiesDao
import com.example.weather.data.local.db.FavoriteDatabase
import com.example.weather.data.network.api.ApiFactory
import com.example.weather.data.network.api.ApiService
import com.example.weather.data.repository.FavoriteRepositoryImpl
import com.example.weather.data.repository.SearchRepositoryImpl
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.FavoriteRepository
import com.example.weather.domain.repository.SearchRepository
import com.example.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavoriteDatabase(context: Context): FavoriteDatabase {
            return FavoriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavoriteCitiesDao(database: FavoriteDatabase): FavoriteCitiesDao {
            return database.favoriteCitiesDao()
        }
    }
}