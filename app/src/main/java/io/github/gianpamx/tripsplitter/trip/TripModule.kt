package io.github.gianpamx.tripsplitter.trip

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.github.gianpamx.tripsplitter.usecase.GetTripUseCase

@Module
class TripModule {
    @Provides
    fun provideTripViewModelFactory(getTripUseCase: GetTripUseCase) =
            TripViewModel.Factory(getTripUseCase)

    @Provides
    fun provideTripViewModel(activity: TripActivity, factory: TripViewModel.Factory) =
            ViewModelProviders.of(activity, factory).get(TripViewModel::class.java)

}
