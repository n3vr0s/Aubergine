package com.n3vr0s.aubergine;

import android.support.test.rule.ActivityTestRule;

import com.n3vr0s.aubergine.app.screens.screen2.Screen2Activity_;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Screen2Sub1ActivityTest {

    @Rule
    public ActivityTestRule<Screen2Activity_> rule = new ActivityTestRule<>(Screen2Activity_.class);

    @Test
    public void testCalculation(){
        onView(withId(R.id.etAddendA)).perform(typeText("3"));
        onView(withId(R.id.etAddendB)).perform(typeText("5"));
        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.tvSum)).check(matches(withText("8")));

    }

}
