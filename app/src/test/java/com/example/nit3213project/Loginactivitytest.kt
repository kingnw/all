package com.example.nit3213project

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

    @Test
    fun testValidLogin() {
        val loginRequest = LoginRequest("testUser", "testPassword")
        assertEquals("testUser", loginRequest.username)
        assertEquals("testPassword", loginRequest.password)
    }

    @Test
    fun testLoginApiCall() {
        // Mocking the ApiService and Call<LoginResponse>
        val mockApiService = mock<ApiService>()
        val mockCall = mock<Call<LoginResponse>>()

        // Mocking the API response
        val loginResponse = LoginResponse("mockKeypass")
        val mockResponse = Response.success(loginResponse)

        // Using Mockito-Kotlin's any() to handle null safety
        `when`(mockApiService.login(any())).thenReturn(mockCall)

        `when`(mockCall.enqueue(any())).thenAnswer {
            val callback = it.arguments[0] as Callback<LoginResponse>
            callback.onResponse(mockCall, mockResponse)
        }

        // Simulating the login API call
        mockApiService.login(LoginRequest("testUser", "testPassword")).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                // Verifying the success of the API call
                assertTrue(response.isSuccessful)
                assertEquals("mockKeypass", response.body()?.keypass)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                fail("API call failed")
            }
        })

        // Verify that the API service's login method was called
        verify(mockApiService).login(any())
    }
}
