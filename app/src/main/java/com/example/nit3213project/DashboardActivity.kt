package com.example.nit3213project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    @Inject
    lateinit var api: ApiService // Inject ApiService

    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter
    private var entities: List<Entity> = emptyList() // List to hold Entity objects

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // Set LinearLayoutManager for RecyclerView

        val keypass = intent.getStringExtra("KEYPASS") // Retrieve keypass from intent

        if (keypass != null) {
            fetchDashboardData(keypass) // Fetch data if keypass is available
        } else {
            Toast.makeText(this, "Keypass is missing!", Toast.LENGTH_SHORT).show() // Show error if keypass is missing
        }
    }

    private fun fetchDashboardData(keypass: String) {
        // Here you would call your API service to fetch the dashboard data
        // For the example, we will continue using mock data
        entities = listOf(
            Entity("Eiffel Tower", "Gustave Eiffel", "Paris, France", 1889, "Structural Expressionism", 324, "An iron lattice tower on the Champ de Mars in Paris, named after the engineer Gustave Eiffel.", R.drawable.dashboardimage),
            Entity("Taj Mahal", "Ustad Ahmad Lahauri", "Agra, India", 1653, "Mughal Architecture", 73, "An ivory-white marble mausoleum in memory of Shah Jahan’s wife, Mumtaz Mahal.", R.drawable.taj_mahal),
            Entity("Sydney Opera House", "Jørn Utzon", "Sydney, Australia", 1973, "Expressionist Modernism", 65, "A performing arts center at Sydney Harbour, and a distinctive building.", R.drawable.sydney_opera_house),
            Entity("Fallingwater", "Frank Lloyd Wright", "Pennsylvania, USA", 1939, "Organic Architecture", 30, "A house designed by Frank Lloyd Wright, partly built over a waterfall.", R.drawable.fallingwater),
            Entity("Burj Khalifa", "Adrian Smith", "Dubai, UAE", 2010, "Neo-futurism", 828, "The tallest structure and building in the world since topping out in 2009.", R.drawable.burj_khalifa),
            Entity("Guggenheim Museum Bilbao", "Frank Gehry", "Bilbao, Spain", 1997, "Deconstructivism", 50, "A museum of modern and contemporary art in Bilbao.", R.drawable.guggenheim),
            Entity("Pantheon", "Unknown", "Rome, Italy", 126, "Ancient Roman Architecture", 43, "A former Roman temple, now a church in Rome.", R.drawable.pantheon)
        )
        setupRecyclerView()  // Call method to setup RecyclerView adapter
    }

    private fun setupRecyclerView() {
        entityAdapter = EntityAdapter(entities) { entity ->
            val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
            intent.putExtra("ENTITY", entity)  // Pass the selected entity to DetailsActivity
            startActivity(intent) // Start DetailsActivity with the selected entity
        }
        recyclerView.adapter = entityAdapter // Set the adapter for the RecyclerView
    }
}
