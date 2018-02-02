package io.github.gianpamx.tripsplitter.triplist

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(TripListModule::class))
interface TripListComponent {
    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: TripListActivity): Builder

        fun build(): TripListComponent

    }

    fun inject(activity: TripListActivity)
}
