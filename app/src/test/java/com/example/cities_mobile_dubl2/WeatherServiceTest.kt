import com.example.cities_mobile_dubl2.model.Current
import com.example.cities_mobile_dubl2.model.Location
import com.example.cities_mobile_dubl2.model.WeatherData
import com.example.cities_mobile_dubl2.network.WeatherService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class WeatherServiceTest {

    @Test
    fun testGetWeather_Success() = runBlocking {
        // Mock the WeatherService interface
        val weatherService = mockk<WeatherService>()

        // Define the expected response data
        val expectedWeatherData = WeatherData(
            location = Location(name = "MockCity"),
            current = Current(temp_c = 22.0f)
            // Provide other necessary data for testing
        )

        // Mock the behavior of the getWeather method
        coEvery {
            weatherService.getWeather(any(), any(), any())
        } returns Response.success(expectedWeatherData)

        // Call the method to be tested
        val response: Response<WeatherData> = weatherService.getWeather("MockCity", "apiKey", "en")

        // Verify the response is successful
        assertEquals(true, response.isSuccessful)

        // Verify the response data is as expected
        val weatherData = response.body()
        assertEquals(expectedWeatherData, weatherData)
    }

    @Test
    fun testGetWeather_Failure() = runBlocking {
        // Mock the WeatherService interface
        val weatherService = mockk<WeatherService>()

        // Mock the behavior of the getWeather method for a failure scenario
        coEvery {
            weatherService.getWeather(any(), any(), any())
        } returns Response.error(500, mockk())

        // Call the method to be tested
        val response: Response<WeatherData> = weatherService.getWeather("MockCity", "apiKey", "en")

        // Verify the response is not successful
        assertEquals(false, response.isSuccessful)
    }
}
