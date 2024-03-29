package uk.ac.bham.student.starmegabucks;

import android.content.Context;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StarmegabucksTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("uk.ac.bham.student.starmegabucks", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule act = new ActivityScenarioRule<>(TopLevelActivity.class);

    @Test
    public void getListCheckDetails(){
        IdlingRegistry.getInstance().register(ApiCountingIdlingResources.getIdlingResource());
        onView(withId(R.id.ListButton)).perform(click());
        onView(withId(R.id.productList)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        IdlingRegistry.getInstance().unregister(ApiCountingIdlingResources.getIdlingResource());
    }
}