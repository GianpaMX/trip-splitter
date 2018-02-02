package io.github.gianpamx.tripsplitter.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.gianpamx.tripsplitter.triplist.TripListActivity
import io.github.gianpamx.tripsplitter.triplist.TripListModule


@Module
abstract class ActivityBinder {
    @ContributesAndroidInjector(modules = arrayOf(TripListModule::class))
    abstract fun bindTripListActivity(): TripListActivity
}
