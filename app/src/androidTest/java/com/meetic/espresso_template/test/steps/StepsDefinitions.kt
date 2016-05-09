package com.meetic.espresso_template.test.steps

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers
import android.test.ActivityInstrumentationTestCase2
import android.view.View
import android.widget.EditText
import com.meetic.espresso_template.DetailActivity
import com.meetic.espresso_template.ListActivity
import com.meetic.espresso_template.LoginActivity
import com.meetic.espresso_template.R
import com.meetic.espresso_template.test.tools.ActivityKiller
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.internal.matchers.TypeSafeMatcher

/**
 * *  Meetic
 * *  Copyright (c) $year. All rights reserved.
 */
class StepsDefinitions : ActivityInstrumentationTestCase2<LoginActivity>(LoginActivity::class.java) {

    @Before("@login")
    @Throws(Exception::class)
    public override fun setUp() {
        super.setUp()


        injectInstrumentation(InstrumentationRegistry.getInstrumentation())
        activity
        Intents.init()
    }

    @After("@login")
    @Throws(Exception::class)
    public override fun tearDown() {
        Intents.release()
        ActivityKiller.killOpenActivities()
        super.tearDown()
    }

    @Given("^I am on the Login screen$")
    fun I_am_on_the_login_screen() {
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
    }

    @When("^I enter my credentials (\\S*) and (\\S*)$")
    fun I_enter_my_credentials_login_and_password(login : String?, password : String?) {
        Espresso.onView(ViewMatchers.withId(R.id.emailEditTextView)).perform(ViewActions.typeText(login))
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditTextView)).perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
    }

    @And("I press login button")
    fun I_press_login_button() {
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click())
    }

    @Then("I see (.*)$")
    fun I_see(result : String) {
        when (result) {
            "errors" -> {
                Espresso.onView(ViewMatchers.withId(R.id.emailEditTextView)).check(ViewAssertions.matches(error()))
            }
            "snackbar error" -> {
                Espresso.onView(ViewMatchers.withText("Invalid user")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            }
            "Logged screen" -> {
                Intents.intended(IntentMatchers.hasComponent(ListActivity::class.java.name))
            }
            "item 42 detail screen" -> {
                Intents.intended(IntentMatchers.hasComponent(DetailActivity::class.java.name))
            }
        }
    }

    fun error() : Matcher<View> = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description?) {
            // do nothing
        }

        override fun matchesSafely(item: View?): Boolean {
            return if (item is EditText) item.error != null else false
        }
    }
}
