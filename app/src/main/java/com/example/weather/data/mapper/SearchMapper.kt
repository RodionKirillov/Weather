package com.example.weather.data.mapper

import com.example.weather.data.network.dto.CityDto
import com.example.weather.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }