package com.example.weather.data.mapper

import com.example.weather.data.local.model.CityDbModel
import com.example.weather.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntityModel(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntityModel() }