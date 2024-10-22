package com.example.nit3213project

// Importing necessary classes for testing and mocking
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*
import org.mockito.kotlin.any  // Safe Kotlin-compatible any()
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityTest {

    // Test case to verify the properties of a LoginRequest object
    @Test
    fun testValidLogin() {
        // Create a LoginRequest object with test credentials
        val loginRequest = LoginRequest("testUser", "testPassword")
        // Assert that the username and password are set correctly
        assertEquals("testUser", loginRequest.username)
        assertEquals("testPassword", loginRequest.password)
    }

    // Test case to verify the login API call functionality
    @Test
    fun testLoginApiCall() {
        // Mocking the ApiService interface and Call<LoginResponse> object
        val mockApiService = mock<ApiService>()
        val mockCall = mock<Call<LoginResponse>>()

        // Create a mock LoginResponse object to simulate API response
        val loginResponse = LoginResponse("mockKeypass")
        val mockResponse = Response.success(loginResponse)

        // Mocking the behavior of the login method to return the mocked Call object
        `when`(mockApiService.login(any())).thenReturn(mockCall)

        // Mock the enqueue method to simulate API response handling
        `when`(mockCall.enqueue(any())).thenAnswer {
            // Get the Callback<LoginResponse> from the method arguments
            val callback = it.arguments[0] as Callback<LoginResponse>
            // Simulate a successful response
            callback.onResponse(mockCall, mockResponse)
        }

        // Simulating the login API call by calling the login method and enqueueing the response
        mockApiService.login(LoginRequest("testUser", "testPassword")).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                // Verifying that the response is successful
                assertTrue(response.isSuccessful)
                // Asserting that the keypass in the response matches the expected mock value
                assertEquals("mockKeypass", response.body()?.keypass)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // If the API call fails, this test case should fail
                fail("API call failed")
            }
        })

        // Verify that the login method of the mocked ApiService was called with any argument
        verify(mockApiService).login(any())
    }
}
