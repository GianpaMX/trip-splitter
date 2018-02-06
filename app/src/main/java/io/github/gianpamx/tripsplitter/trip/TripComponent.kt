package io.github.gianpamx.tripsplitter.trip

import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(TripModule::class))
interface TripComponent {
    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: TripActivity): Builder

        fun build(): TripComponent

    }

    fun inject(activity: TripActivity)
}
