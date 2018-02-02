package io.github.gianpamx.tripsplitter.triplist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.github.gianpamx.tripsplitter.triplist.Mappers.mapTripListItem
import io.github.gianpamx.tripsplitter.usecase.GetAllTripsUseCase

class TripListViewModel : ViewModel {
    val tripList = MutableLiveData<List<TripListItem>>()

    constructor(getAllTripsUseCase: GetAllTripsUseCase) {
        tripList.postValue(emptyList())

        getAllTripsUseCase.execute {
            tripList.postValue(it.map { mapTripListItem(it) })
        }
    }

    class Factory(val getAllTripsUseCase: GetAllTripsUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TripListViewModel(getAllTripsUseCase) as T
        }
    }
}
