package com.meetic.espresso_template.test.runner;

import android.os.Bundle;
import android.support.test.runner.MonitoringInstrumentation;
import cucumber.api.android.CucumberInstrumentationCore;

/**
 * *  Meetic
 * *  Copyright (c) 2016. All rights reserved.
 */
public class CucumberTestRunner extends MonitoringInstrumentation {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);

        instrumentationCore.create(arguments);
        start();
    }

    @Override
    public void onStart() {
        super.onStart();

        waitForIdleSync();
        instrumentationCore.start();
    }
}