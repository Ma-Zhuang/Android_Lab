package cs.bham.ac.uk.britishlibrary;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StorageMenuTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("cs.bham.ac.uk.britishlibary", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule act = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkLayout(){
        onView(withId(R.id.borrowLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.borrowerID)).check(matches(isDisplayed()));
        onView(withId(R.id.setBorrowerID)).check(matches(isDisplayed()));
        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.borrowerID)));
        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));
        onView(withId(R.id.borrowerID)).check(isCompletelyLeftOf(withId(R.id.setBorrowerID)));
    }

    @Test
    public void checkSharedPref(){
        final String TEST_ID = "a-very-test-id";
        onView(withId(R.id.borrowerID)).perform(clearText());
        onView(withId(R.id.borrowerID)).perform(typeText(TEST_ID));
        onView(withId(R.id.setBorrowerID)).perform(click());
        act.getScenario().close();
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.borrowerID)).check(matches(withText(TEST_ID)));
    }

    @Test
    public void menuInteraction(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getContext());
        onView(withText("Options")).perform(click());
        onView(withId(R.id.optionsLabel)).check(matches(isDisplayed()));
    }

}
