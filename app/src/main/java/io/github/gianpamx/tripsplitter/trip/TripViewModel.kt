package io.github.gianpamx.tripsplitter.trip

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import io.github.gianpamx.tripsplitter.trip.Mappers.mapTripModel
import io.github.gianpamx.tripsplitter.usecase.GetTripUseCase

class TripViewModel : ViewModel {
    val trip = MutableLiveData<TripModel>()

    private var tripId: String? = null

    private var getTripUseCase: GetTripUseCase

    constructor(getTripUseCase: GetTripUseCase) {
        this.getTripUseCase = getTripUseCase
    }

    fun loadTrip(tripId: String) {
        if (tripId != this.tripId) {
            this.tripId = tripId

            getTripUseCase.execute(tripId, {
                trip.postValue(mapTripModel(it))
            })
        }
    }

    class Factory(private val getTripUseCase: GetTripUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TripViewModel(getTripUseCase) as T
        }
    }
}
