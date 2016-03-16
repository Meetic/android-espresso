package com.meetic.espresso_template.test.steps

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.test.ActivityInstrumentationTestCase2

import com.meetic.espresso_template.LoginActivity
import com.meetic.espresso_template.R
import com.meetic.espresso_template.test.tools.ActivityKiller

import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import kotlinx.android.synthetic.main.login_activity.*

/**
 * *  Meetic
 * *  Copyright (c) $year. All rights reserved.
 */
class StepsDefinitions : ActivityInstrumentationTestCase2<LoginActivity>(LoginActivity::class.java) {

    @Before
    @Throws(Exception::class)
    public override fun setUp() {
        super.setUp()

        injectInstrumentation(InstrumentationRegistry.getInstrumentation())
        activity
    }

    @After
    @Throws(Exception::class)
    public override fun tearDown() {
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
}
