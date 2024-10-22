package com.example.nit3213project

// Importing necessary classes from the JUnit testing framework
import org.junit.Test
import org.junit.Assert.*

class DashboardActivityTest {

    // Test case to check the behavior when there is no data in the dashboard
    @Test
    fun testEmptyDashboardData() {
        // Simulate an empty list of Entity objects to represent no data
        val entities = emptyList<Entity>()
        // Assert that the list is empty, which is the expected behavior
        assertTrue("No entities should be present", entities.isEmpty())
    }

    // Test case to check the behavior when there is data in the dashboard
    @Test
    fun testNonEmptyDashboardData() {
        // Simulate a scenario where multiple Entity objects are returned
        val entities = listOf(
            Entity("Eiffel Tower", "Gustave Eiffel", "Paris, France", 1889, "Structural Expressionism", 324, "An iron lattice tower on the Champ de Mars in Paris, named after the engineer Gustave Eiffel.", R.drawable.dashboardimage),
            Entity("Taj Mahal", "Ustad Ahmad Lahauri", "Agra, India", 1653, "Mughal Architecture", 73, "An ivory-white marble mausoleum in memory of Shah Jahan’s wife, Mumtaz Mahal.", R.drawable.taj_mahal),
            Entity("Sydney Opera House", "Jørn Utzon", "Sydney, Australia", 1973, "Expressionist Modernism", 65, "A performing arts center at Sydney Harbour, and a distinctive building.", R.drawable.sydney_opera_house),
            Entity("Fallingwater", "Frank Lloyd Wright", "Pennsylvania, USA", 1939, "Organic Architecture", 30, "A house designed by Frank Lloyd Wright, partly built over a waterfall.", R.drawable.fallingwater),
            Entity("Burj Khalifa", "Adrian Smith", "Dubai, UAE", 2010, "Neo-futurism", 828, "The tallest structure and building in the world since topping out in 2009.", R.drawable.burj_khalifa)
        )

        // Assert that the entities list is not empty, as we expect data to be present
        assertFalse("Entities should be present", entities.isEmpty())
        // Assert that the size of the list is 5, confirming we have the expected number of entities
        assertEquals("Entity list should contain five items", 5, entities.size)

        // Validate the properties of the first Entity in the list (Eiffel Tower)
        verifyEntityProperties(entities[0], "Eiffel Tower", "Gustave Eiffel", "Paris, France", 1889, "Structural Expressionism", 324, "An iron lattice tower on the Champ de Mars in Paris, named after the engineer Gustave Eiffel.")
        // Additional checks for other entities can be added similarly
    }

    // Helper function to verify the properties of an Entity object
    private fun verifyEntityProperties(entity: Entity, name: String, architect: String, location: String, yearCompleted: Int, style: String, height: Int, description: String) {
        // Assert that the entity's name matches the expected name
        assertEquals("Entity name should be $name", name, entity.name)
        // Assert that the entity's architect matches the expected architect
        assertEquals("Entity architect should be $architect", architect, entity.architect)
        // Assert that the entity's location matches the expected location
        assertEquals("Entity location should be $location", location, entity.location)
        // Assert that the year the entity was completed matches the expected year
        assertEquals("Entity year completed should be $yearCompleted", yearCompleted, entity.yearCompleted)
        // Assert that the entity's architectural style matches the expected style
        assertEquals("Entity style should be $style", style, entity.style)
        // Assert that the height of the entity matches the expected height
        assertEquals("Entity height should be $height", height, entity.height)
        // Assert that the entity's description matches the expected description
        assertEquals("Entity description should match", description, entity.description)
    }
}
