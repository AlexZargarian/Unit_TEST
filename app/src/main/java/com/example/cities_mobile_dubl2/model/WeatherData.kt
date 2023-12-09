package com.example.cities_mobile_dubl2.model

data class WeatherData(
    val location: com.example.cities_mobile_dubl2.model.Location,
    val current: Current
)

data class Location(
    val name: String
)

data class Current(
    val temp_c: Float
)