package uk.ac.bham.student.week5;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CreateMessageInstrumentedTest {

    final String TEST_MESSAGE = "Yeah, here is a test message.";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("uk.ac.bham.student.week5", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<CreateMessageActivity> mActivityTestRule = new ActivityScenarioRule<>(CreateMessageActivity.class);

    @Test
    public void checkCreateAppearance() {
        onView(withId(R.id.send)).check(matches(isDisplayed()));
        onView(withId(R.id.message)).check(matches(isDisplayed()));
        onView(withId(R.id.send)).check(isCompletelyAbove(withId(R.id.message)));
    }

    @Test
    public void checkFillAndSend() {
        onView(withId(R.id.message)).perform(typeText(TEST_MESSAGE));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.messageReceived)).check(matches(isDisplayed()));
        onView(withId(R.id.messageReceived)).check(matches(withText(TEST_MESSAGE)));
    }
}