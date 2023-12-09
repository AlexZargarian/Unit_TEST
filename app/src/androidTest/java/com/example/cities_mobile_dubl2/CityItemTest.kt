package com.example.cities_mobile_dubl2

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.cities_mobile_dubl2.model.City
import com.example.cities_mobile_dubl2.view.CityItem
import org.junit.Rule
import org.junit.Test

class CityItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun cityItemContentIsDisplayed() {
        // Create a sample City object for testing
        val city = City(
            name = "Sample City",
            description = "Description of the city",
            imageRes = R.drawable.sample_image // Replace with a valid resource ID
        )

        // Run the Compose UI test
        composeTestRule.setContent {
            CityItem(city = city)
        }

        // Verify that the UI components are displayed correctly
        composeTestRule.onNodeWithText("Sample City").assertExists()
        composeTestRule.onNodeWithText("Description of the city").assertExists()
    }
}
