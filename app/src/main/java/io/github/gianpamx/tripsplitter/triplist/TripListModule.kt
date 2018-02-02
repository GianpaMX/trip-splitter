package io.github.gianpamx.tripsplitter.triplist

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import io.github.gianpamx.tripsplitter.usecase.GetAllTripsUseCase

@Module
class TripListModule {
    @Provides
    fun provideTripListViewModelFactory(getAllTripsUseCase: GetAllTripsUseCase) =
            TripListViewModel.Factory(getAllTripsUseCase)

    @Provides
    fun provideTripListViewModel(activity: TripListActivity, factory: TripListViewModel.Factory) =
            ViewModelProviders.of(activity, factory).get(TripListViewModel::class.java)
}
