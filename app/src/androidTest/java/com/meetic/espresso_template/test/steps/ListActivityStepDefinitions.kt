package com.meetic.espresso_template.test.steps

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers
import android.test.ActivityInstrumentationTestCase2
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

/**
 * Created by g.tan on 02/05/2016.
 */
class ListActivityStepDefinitions : ActivityInstrumentationTestCase2<LoginActivity>(LoginActivity::class.java) {

    @Before("@detail")
    @Throws(Exception::class)
    public override fun setUp() {
        super.setUp()


        injectInstrumentation(InstrumentationRegistry.getInstrumentation())
        activity
        Intents.init()
    }

    @After("@detail")
    @Throws(Exception::class)
    public override fun tearDown() {
        Intents.release()
        ActivityKiller.killOpenActivities()
        super.tearDown()
    }

    @Given("^I am a logged user")
    fun I_am_a_logged_user() {
        Espresso.onView(ViewMatchers.withId(R.id.emailEditTextView)).perform(ViewActions.typeText("test"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordEditTextView)).perform(ViewActions.typeText("test"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click())
        Intents.intended(IntentMatchers.hasComponent(ListActivity::class.java.name))
    }

    @When("^I scroll down to item 42")
    fun I_scroll_down_to_item_42() {

        Espresso.onData(ViewMatchers.withId(R.id.text))
                .check(ViewAssertions.matches(ViewMatchers.withText("item 42")))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        Espresso.onData(Matchers.hasEntry(Matchers.equalTo(""))).
//        val action = ViewActions.scrollTo()
//        Espresso.onView(ViewMatchers.withId(R.id.listView)).perform(action)
    }

    @And("^I press item 42")
    fun I_press_item_42() {
//        val action = RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(42, ViewActions.click())
//        Espresso.onView(ViewMatchers.withId(R.id.listView)).perform(action)
    }

    @Then("^I see item 42 detail screen")
    fun I_see_item_42_detail_screen() {

    }
}