package com.example.nit3213project

import org.junit.Test
import org.junit.Assert.*

class DashboardActivityTest {

    @Test
    fun testEmptyDashboardData() {
        // Simulate empty data case
        val entities = emptyList<Entity>()
        assertTrue("No entities should be present", entities.isEmpty())
    }

    @Test
    fun testNonEmptyDashboardData() {
        // Simulate a case where entities are returned
        val entities = listOf(
            Entity("Eiffel Tower", "Gustave Eiffel", "Paris, France", 1889, "Structural Expressionism", 324, "An iron lattice tower on the Champ de Mars in Paris, named after the engineer Gustave Eiffel.", R.drawable.dashboardimage),
            Entity("Taj Mahal", "Ustad Ahmad Lahauri", "Agra, India", 1653, "Mughal Architecture", 73, "An ivory-white marble mausoleum in memory of Shah Jahan’s wife, Mumtaz Mahal.", R.drawable.taj_mahal),
            Entity("Sydney Opera House", "Jørn Utzon", "Sydney, Australia", 1973, "Expressionist Modernism", 65, "A performing arts center at Sydney Harbour, and a distinctive building.", R.drawable.sydney_opera_house),
            Entity("Fallingwater", "Frank Lloyd Wright", "Pennsylvania, USA", 1939, "Organic Architecture", 30, "A house designed by Frank Lloyd Wright, partly built over a waterfall.", R.drawable.fallingwater),
            Entity("Burj Khalifa", "Adrian Smith", "Dubai, UAE", 2010, "Neo-futurism", 828, "The tallest structure and building in the world since topping out in 2009.", R.drawable.burj_khalifa)
        )

        assertFalse("Entities should be present", entities.isEmpty())
        assertEquals("Entity list should contain five items", 5, entities.size)

        // Check properties of each entity
        assertEquals("Entity name should be Eiffel Tower", "Eiffel Tower", entities[0].name)
        assertEquals("Entity architect should be Gustave Eiffel", "Gustave Eiffel", entities[0].architect)
        assertEquals("Entity location should be Paris, France", "Paris, France", entities[0].location)
        assertEquals("Entity year completed should be 1889", 1889, entities[0].yearCompleted)
        assertEquals("Entity style should be Structural Expressionism", "Structural Expressionism", entities[0].style)
        assertEquals("Entity height should be 324", 324, entities[0].height)
        assertEquals("Entity description should match",
            "An iron lattice tower on the Champ de Mars in Paris, named after the engineer Gustave Eiffel.",
            entities[0].description)
        // Add similar checks for other entities as needed
    }
}
