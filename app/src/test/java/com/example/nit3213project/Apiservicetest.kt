package com.example.nit3213project

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Response

class ApiServiceTest {

    private lateinit var apiService: ApiService
    private lateinit var mockCall: Call<LoginResponse>

    @Before
    fun setUp() {
        val mockApiService = Mockito.mock(ApiService::class.java)
        val loginRequest = LoginRequest("username", "password")
        mockCall = Mockito.mock(Call::class.java) as Call<LoginResponse>

        // Mock the API response
        Mockito.`when`(mockApiService.login(loginRequest)).thenReturn(mockCall)

        apiService = mockApiService
    }

    @Test
    fun testLogin() {
        val response = LoginResponse("mockKeypass")
        Mockito.`when`(mockCall.execute()).thenReturn(Response.success(response))

        val result = apiService.login(LoginRequest("username", "password")).execute().body()

        assertEquals("mockKeypass", result?.keypass)
    }
}
