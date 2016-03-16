package com.meetic.espresso_template.test;

import junit.framework.TestCase;

import cucumber.api.CucumberOptions;

/**
 * *  Meetic
 * *  Copyright (c) $year. All rights reserved.
 */
@CucumberOptions(
        glue = "com.meetic.espresso_template.test.steps",
        features = "features",
        plugin = {
                "pretty",
                // To create directory app needs permission once
                "html:/mnt/sdcard/com.meetic.espresso_template.test.test/cucumber-reports/report-html"
        }
)
public class CucumberTest extends TestCase {
}
