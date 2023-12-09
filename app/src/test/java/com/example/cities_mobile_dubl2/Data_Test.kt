package com.example.cities_mobile_dubl2


import com.example.cities_mobile_dubl2.model.City
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class Data_Test {

    @Test
    fun testCityProperties() {
        // Arrange
        val cityName = "Yerevan"
        val cityDescription = "Beautiful city"
        val imageRes = 123

        // Act
        val city = City(cityName, cityDescription, imageRes)

        // Assert
        assertEquals(cityName, city.name)
        assertEquals(cityDescription, city.description)
        assertEquals(imageRes, city.imageRes)
    }

    @Test
    fun testCityEquality() {
        // Arrange
        val city1 = City("Yerevan", "Beautiful city", 123)
        val city2 = City("Yerevan", "Beautiful city", 123)

        // Assert
        assertEquals(city1, city2)
    }

    @Test
    fun testCityToString() {
        // Arrange
        val city = City("Yerevan", "Beautiful city", 123)

        // Assert
        assertEquals("City(name=Yerevan, description=Beautiful city, imageRes=123)", city.toString())
    }

    @Test
    fun testCityCopy() {
        // Arrange
        val originalCity = City("Yerevan", "Beautiful city", 123)

        // Act
        val copiedCity = originalCity.copy()

        // Assert
        assertEquals(originalCity, copiedCity)
    }
}
