package uk.ac.bham.student.week7_bundles_and_threads;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("uk.ac.bham.student.week7_bundles_and_threads", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule act = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkViews(){
        onView(withId(R.id.start)).check(matches(isDisplayed()));
        onView(withId(R.id.stop)).check(matches(isDisplayed()));
        onView(withId(R.id.stop)).check(matches(isDisplayed()));
        onView(withId(R.id.timer)).check(matches(isDisplayed()));
    }

    @Test
    public void startStopResetTimer(){
        onView(withId(R.id.start)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.stop)).perform(click());
        try {
            //Give the clock time to settle
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        String timeNow = getText(withId(R.id.timer));
        onView(withId(R.id.timer)).check(matches(not(withText("00:00:00"))));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(withText(timeNow)));
        onView(withId(R.id.start)).perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(not(withText(timeNow))));

        onView(withId(R.id.reset)).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(withText("00:00:00")));
    }

    // Thanks StackOverflow for this!
    // https://stackoverflow.com/questions/23381459/how-to-get-text-from-textview-using-espresso
    String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }
}