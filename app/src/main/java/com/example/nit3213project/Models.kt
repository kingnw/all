package com.example.nit3213project

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Data class for login request, containing username and password
data class LoginRequest(
    val username: String,  // Username entered by the user
    val password: String   // Password entered by the user
)

// Data class for login response, containing the keypass for further authentication
data class LoginResponse(
    val keypass: String    // Keypass received upon successful login
)

// Data class for dashboard response, containing a list of entities and the total count
data class DashboardResponse(
    val entities: List<Entity>,  // List of Entity objects
    val entityTotal: Int         // Total number of entities
)

// Parcelable data class for Entity, allowing it to be passed between activities
@Parcelize
data class Entity(
    val name: String,           // Name of the entity (e.g., building)
    val architect: String,      // Architect of the structure
    val location: String,       // Location (City, Country)
    val yearCompleted: Int,     // Year the structure was completed
    val style: String,          // Architectural style
    val height: Int,            // Height of the structure in meters
    val description: String,     // Detailed description of the entity
    val imageResource: Int      // Resource ID for the entity's image
) : Parcelable // Allows this class to be passed between Android components
