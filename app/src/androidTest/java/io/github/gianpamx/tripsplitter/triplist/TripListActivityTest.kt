package io.github.gianpamx.tripsplitter.triplist

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.support.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class TripListActivityTest {
    @Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(TripListActivity::class.java)

    @Test
    fun setUp() {
    }
}
