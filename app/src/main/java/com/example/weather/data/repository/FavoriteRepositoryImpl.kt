package com.example.weather.data.repository

import com.example.weather.data.local.db.FavoriteCitiesDao
import com.example.weather.data.mapper.toDbModel
import com.example.weather.data.mapper.toEntities
import com.example.weather.domain.entity.City
import com.example.weather.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteCitiesDao: FavoriteCitiesDao
): FavoriteRepository {

    override val favoriteCities: Flow<List<City>> = favoriteCitiesDao.getFavoriteCities()
        .map { it.toEntities() }

    override fun observeIsFavorite(citiId: Int): Flow<Boolean> = favoriteCitiesDao
        .observeIsFavorite(citiId)

    override suspend fun addToFavorite(city: City) {
        favoriteCitiesDao.addToFavorite(city.toDbModel())
    }

    override suspend fun removeFromFavorite(citiId: Int) {
        favoriteCitiesDao.removeFromFavorite(citiId)
    }
}