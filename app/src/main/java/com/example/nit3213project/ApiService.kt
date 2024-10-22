package com.example.nit3213project

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path

// This interface defines the API service for our app.
// It contains two methods, one for logging in and one for fetching dashboard data.

interface ApiService {

    // POST request for user login.
    // We send the loginRequest object (username, password) to the server and expect a LoginResponse in return.
    // The endpoint "/footscray/auth" might need to be adjusted based on where the service is hosted (e.g., different location).
    @POST("/footscray/auth")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    // GET request for fetching dashboard data.
    // We pass the user's keypass in the URL path and expect a DashboardResponse that contains the data for their dashboard.
    @GET("/dashboard/{keypass}")
    fun getDashboardData(@Path("keypass") keypass: String): Call<DashboardResponse>
}
