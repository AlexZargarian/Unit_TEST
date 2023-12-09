import com.example.cities_mobile_dubl2.model.City
import org.junit.Assert.assertEquals
import org.junit.Test

class CityTest {

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
}
