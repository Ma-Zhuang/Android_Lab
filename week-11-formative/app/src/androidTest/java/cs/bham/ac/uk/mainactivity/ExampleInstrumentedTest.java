package cs.bham.ac.uk.mainactivity;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.instanceOf;
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
        assertEquals("cs.bham.ac.uk.typo", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<MainActivity> r = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkTV(){
        onView(withId(R.id.coolTV)).check(matches(isDisplayed()));
        onView(withId(R.id.coolTV)).check(matches(instanceOf(TextView.class)));
        onView(withId(R.id.coolTV)).check(matches(withText("Super super cool stuff.")));
    }

    @Test
    public void positionsCheck(){
        onView(withId(R.id.coolTV)).check(matches(isDisplayed()));
        onView(withId(R.id.goodButton)).check(matches(instanceOf(Button.class)));
        onView(withId(R.id.goodButton)).check(matches(isDisplayed()));
        onView(withId(R.id.goodButton)).check(isCompletelyBelow(withId(R.id.coolTV)));
    }

    @Test
    public void textViewConstraints() {
        onView(withId(R.id.goodButton)).check(matches(hasCorrectTextViewConstraints()));
    }

    Matcher<View> hasCorrectTextViewConstraints(){
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("Check if this TextView has the correct constraints set.");
            }

            @Override
            public boolean matchesSafely(TextView tv) {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) tv.getLayoutParams();
                DisplayMetrics displayMetrics = tv.getContext().getResources().getDisplayMetrics();
                int dpSize = (int) ((params.leftMargin/displayMetrics.density)+0.5);
                return dpSize == 32;
            }
        };
    }

    @Test
    public void doSomeTyping(){
        String TEST_STR = "VERY-VERY-TEST";
        onView(withId(R.id.editTextYourStuff)).check(matches(instanceOf(EditText.class)));
        onView(withId(R.id.editTextYourStuff)).perform(typeText(TEST_STR));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard()); //This just makes sure the keyboard is closed, else it might be obscuring our button!
        onView(withId(R.id.goodButton)).perform(click());
        onView(withId(R.id.coolTV)).check(matches(withText(TEST_STR)));
    }
}