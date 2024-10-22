package com.example.nit3213project

// Import necessary Android and UI libraries
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

// Activity to display detailed information of an entity (e.g., building)
class DetailsActivity : AppCompatActivity() {

    // This method is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for the activity from activity_details.xml
        setContentView(R.layout.activity_details)

        // Set up the toolbar and enable back navigation
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar) // Use the toolbar as the app's action bar

        // Enable the "Up" button (back navigation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get the passed Entity object from the intent
        val entity = intent.getParcelableExtra<Entity>("ENTITY")

        // Bind views to display entity details
        val imageView = findViewById<ImageView>(R.id.entityImageView)  // Image view to display entity's image
        val nameTextView = findViewById<TextView>(R.id.nameTextView)  // Text view for entity's name
        val locationTextView = findViewById<TextView>(R.id.locationTextView)  // Text view for entity's location
        val yearTextView = findViewById<TextView>(R.id.yearTextView)  // Text view for year the entity was completed
        val architectTextView = findViewById<TextView>(R.id.architectTextView)  // Text view for architect's name
        val styleTextView = findViewById<TextView>(R.id.styleTextView)  // Text view for architectural style
        val heightTextView = findViewById<TextView>(R.id.heightTextView)  // Text view for building's height
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)  // Text view for entity's description

        // Populate views with entity details if the entity is not null
        entity?.let {
            nameTextView.text = it.name  // Set name
            locationTextView.text = it.location  // Set location
            yearTextView.text = it.yearCompleted.toString()  // Set year of completion
            architectTextView.text = it.architect  // Set architect
            styleTextView.text = it.style  // Set architectural style
            heightTextView.text = it.height.toString()  // Set height
            descriptionTextView.text = it.description  // Set description

            // Set the image resource for the entity's image
            imageView.setImageResource(it.imageResource)
        }
    }

    // Handle toolbar options, including the "Up" button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Handle back navigation when the "Up" button is pressed
            android.R.id.home -> {
                finish()  // Close DetailsActivity and return to the previous screen
                true
            }
            else -> super.onOptionsItemSelected(item)  // Default behavior for other menu items
        }
    }
}
