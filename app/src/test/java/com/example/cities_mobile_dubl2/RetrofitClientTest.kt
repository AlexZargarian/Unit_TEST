package com.example.cities_mobile_dubl2

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cities_mobile_dubl2.constants.BASE_URL
import com.example.cities_mobile_dubl2.model.WeatherData
import com.example.cities_mobile_dubl2.network.RetrofitClient
import com.example.cities_mobile_dubl2.network.WeatherService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
@RunWith(AndroidJUnit4::class)
class RetrofitClientTest {

    @Test
    fun testRetrofitCreation() {
        // Assert that Retrofit instance is created with the correct base URL
        val retrofit = RetrofitClient.retrofit
        assertEquals(retrofit.baseUrl().toString(), BASE_URL)

        // Access converterFactories using custom extension function
        val converterFactories = retrofit.getConverterFactories()

        // Assert that converterFactories contains GsonConverterFactory
        assertTrue(converterFactories.any { it is GsonConverterFactory })

        // Assert that WeatherService is created correctly
        val weatherService = RetrofitClient.weatherService
        assertNotNull(weatherService)
        assertTrue(weatherService is WeatherService)
    }

    private fun Retrofit.getConverterFactories(): List<*> {
        val converterFactoriesField = javaClass.getDeclaredField("converterFactories")
        converterFactoriesField.isAccessible = true
        return converterFactoriesField.get(this) as List<*>
    }
}