package com.example.nit3213project

// Importing necessary classes for assertions, setup, test cases, and mocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Response

class ApiServiceTest {

    // Declare variables to hold the ApiService and mocked Call objects
    private lateinit var apiService: ApiService
    private lateinit var mockCall: Call<LoginResponse>

    // This method runs before each test case to set up the test environment
    @Before
    fun setUp() {
        // Create a mock instance of ApiService using Mockito
        val mockApiService = Mockito.mock(ApiService::class.java)
        // Create a LoginRequest object with test credentials
        val loginRequest = LoginRequest("username", "password")
        // Create a mock Call object for LoginResponse
        mockCall = Mockito.mock(Call::class.java) as Call<LoginResponse>

        // Mock the behavior of the login method to return the mocked Call
        Mockito.`when`(mockApiService.login(loginRequest)).thenReturn(mockCall)

        // Assign the mocked ApiService to the class variable
        apiService = mockApiService
    }

    // Test case to verify the login functionality
    @Test
    fun testLogin() {
        // Create a mock LoginResponse with a mock keypass
        val response = LoginResponse("mockKeypass")
        // Mock the Call's execute method to return a successful response with the mock LoginResponse
        Mockito.`when`(mockCall.execute()).thenReturn(Response.success(response))

        // Call the login method on the ApiService and execute it to get the response body
        val result = apiService.login(LoginRequest("username", "password")).execute().body()

        // Assert that the keypass in the response matches the expected value
        assertEquals("mockKeypass", result?.keypass)
    }
}
