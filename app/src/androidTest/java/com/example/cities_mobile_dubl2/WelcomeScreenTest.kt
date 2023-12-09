import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import com.example.cities_mobile_dubl2.MainActivity
import com.example.cities_mobile_dubl2.model.WeatherData
import com.example.cities_mobile_dubl2.viewmodel.WeatherViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import com.example.cities_mobile_dubl2.ui.WelcomeScreen

class WelcomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun welcomeScreen_showsLocationData() {
        // Mock dependencies
        val mockNavController = mock(NavController::class.java)
        val mockActivity = mock(MainActivity::class.java)
        val mockViewModel = mock(WeatherViewModel::class.java)

        // Mock location permission
        `when`(mockActivity.checkLocationPermission()).thenReturn(true)

        // Mock weather data
        val weatherData = mock(WeatherData::class.java)
        `when`(mockViewModel.weatherData.value).thenReturn(listOf(weatherData))

        // Compose the UI
        composeTestRule.setContent {
            WelcomeScreen(mockNavController, mockActivity, mockViewModel)
        }

        // Verify the UI elements
        composeTestRule.onNodeWithText("Current Temperature").assertExists()
    }
}