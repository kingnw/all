package com.example.nit3213project

// Import necessary Android, Retrofit, and Dagger Hilt libraries
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

// The @AndroidEntryPoint annotation allows this activity to use dependency injection (Hilt)
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    // Inject ApiService to make network requests
    @Inject
    lateinit var api: ApiService

    // This method is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content layout to activity_login.xml
        setContentView(R.layout.activity_login)

        // Find references to the EditText fields and the login button in the layout
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Set a click listener on the login button
        loginButton.setOnClickListener {
            // Get the input from the username and password fields
            val username = usernameEditText.text.toString().trim() // Get and trim the username
            val password = passwordEditText.text.toString().trim() // Get and trim the password

            // Check if either username or password is empty
            if (username.isEmpty() || password.isEmpty()) {
                // Show a message if fields are empty
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_SHORT).show()
            } else {
                // Create a LoginRequest object with the entered username and password
                val loginRequest = LoginRequest(username, password)

                // Call the login API with the login request
                api.login(loginRequest).enqueue(object : Callback<LoginResponse> {
                    // Handle successful API responses
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            // Extract keypass if available in the response
                            val keypass = response.body()?.keypass
                            if (keypass != null) {
                                // Create an Intent to navigate to the DashboardActivity
                                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                                // Pass the keypass to the next activity
                                intent.putExtra("KEYPASS", keypass)

                                // Clear LoginActivity from the backstack to prevent going back to it
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent) // Start the DashboardActivity
                            }
                        } else {
                            // Show an error message if credentials are invalid
                            Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                        }
                    }

                    // Handle API call failure (e.g., network error)
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Show an error message if the login request fails
                        Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}
