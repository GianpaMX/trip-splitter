package io.github.gianpamx.tripsplitter.data.room

import io.github.gianpamx.tripsplitter.entity.Trip

object Mappers {
    fun mapTripDataModel(trip: Trip): TripDataModel {
        val tripDataModel = TripDataModel()
        tripDataModel.id = trip.id
        tripDataModel.name = trip.name
        return tripDataModel
    }

    fun mapTrip(tripDataModel: TripDataModel): Trip {
        val trip = Trip()
        trip.id = tripDataModel.id
        trip.name = tripDataModel.name
        return trip
    }
}
