import com.example.cities_mobile_dubl2.model.Current
import com.example.cities_mobile_dubl2.model.Location
import com.example.cities_mobile_dubl2.model.WeatherData
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherDataTest {

    @Test
    fun testWeatherDataProperties() {
        // Arrange
        val location = Location("Yerevan")
        val current = Current(25.5f)

        // Act
        val weatherData = WeatherData(location, current)

        // Assert
        assertEquals(location, weatherData.location)
        assertEquals(current, weatherData.current)
    }

    @Test
    fun testWeatherDataEquality() {
        // Arrange
        val location = Location("Yerevan")
        val current = Current(25.5f)
        val weatherData1 = WeatherData(location, current)
        val weatherData2 = WeatherData(location, current)

        // Assert
        assertEquals(weatherData1, weatherData2)
    }

    @Test
    fun testWeatherDataToString() {
        // Arrange
        val location = Location("Yerevan")
        val current = Current(25.5f)
        val weatherData = WeatherData(location, current)

        // Assert
        assertEquals("WeatherData(location=Location(name=Yerevan), current=Current(temp_c=25.5))", weatherData.toString())
    }

    @Test
    fun testWeatherDataCopy() {
        // Arrange
        val originalLocation = Location("Yerevan")
        val originalCurrent = Current(25.5f)
        val originalWeatherData = WeatherData(originalLocation, originalCurrent)

        // Act
        val copiedWeatherData = originalWeatherData.copy()

        // Assert
        assertEquals(originalWeatherData, copiedWeatherData)
    }
}
