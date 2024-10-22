package com.example.nit3213project

// Importing necessary libraries for activity lifecycle, window insets, and Dagger Hilt
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint

// @AndroidEntryPoint is required to inject dependencies into Android classes (like activities)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This enables edge-to-edge display, extending content into system UI areas (like status bar and navigation bar)
        enableEdgeToEdge()

        // Set the activity's layout to activity_main.xml
        setContentView(R.layout.activity_main)

        // Adjust the padding of the root view (with id "main") based on system window insets (e.g., status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Get the size of the system bars (status and navigation bars)
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Set padding on the view to account for system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            // Return the insets so other parts of the layout can process them if needed
            insets
        }
    }
}
