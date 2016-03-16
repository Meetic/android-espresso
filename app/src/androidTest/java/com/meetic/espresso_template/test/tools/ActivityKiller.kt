/*
 * Meetic
 * Copyright (c) 2016. All rights reserved.
 */

package com.meetic.espresso_template.test.tools

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.support.test.runner.lifecycle.ActivityLifecycleMonitor
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage

import java.util.ArrayList
import java.util.EnumSet

class ActivityKiller private constructor() : Runnable {

    private val activityLifecycleMonitor: ActivityLifecycleMonitor

    init {
        this.activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance()
    }

    override fun run() {
        val activities = ArrayList<Activity>()

        for (stage in EnumSet.range(Stage.CREATED, Stage.STOPPED)) {
            activities.addAll(activityLifecycleMonitor.getActivitiesInStage(stage))
        }

        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    companion object {

        fun killOpenActivities() {
            Handler(Looper.getMainLooper()).post(ActivityKiller())
        }
    }
}