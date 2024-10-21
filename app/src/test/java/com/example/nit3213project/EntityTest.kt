import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EntityLayoutTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEntityFieldsAreDisplayed() {
        // Check if the 'Name' TextView is displayed and contains the correct text
        onView(withId(R.id.property1TextView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Name")))

        // Check if the 'Location' TextView is displayed and contains the correct text
        onView(withId(R.id.property2TextView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Location")))

        // Check if the 'Year Completed' TextView is displayed and contains the correct text
        onView(withId(R.id.property3TextView))
            .check(matches(isDisplayed()))
            .check(matches(withText("Year Completed")))
    }
}
