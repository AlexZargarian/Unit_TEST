import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cities_mobile_dubl2.model.Current
import com.example.cities_mobile_dubl2.model.Location
import com.example.cities_mobile_dubl2.model.WeatherData
import com.example.cities_mobile_dubl2.ui.CitiesScreen
import com.example.cities_mobile_dubl2.viewmodel.WeatherViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@RequiresApi(Build.VERSION_CODES.Q)
class CitiesScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun citiesScreen_displaysGoBackButton() {
        // Create a mock NavHostController
        val mockNavController = mock(NavHostController::class.java)

        // Create a mock WeatherViewModel
        val mockViewModel = mock(WeatherViewModel::class.java)

        // Set the initial state of the WeatherViewModel with some mocked data
        val mockedWeatherData = WeatherData(
            location = Location(name = "MockCity"),
            current = Current(temp_c = 22.0f) // replace with the desired temperature for testing
        )
        `when`(mockViewModel.weatherData.value).thenReturn(listOf(mockedWeatherData))

        // Compose the CitiesScreen
        composeTestRule.setContent {
            CitiesScreen(navController = mockNavController, viewModel = mockViewModel)
        }

        // Verify that the "Go Back" button is displayed
        composeTestRule.onNodeWithText("Go Back").assertExists()
    }

    // Add more test cases as needed for different scenarios
}
