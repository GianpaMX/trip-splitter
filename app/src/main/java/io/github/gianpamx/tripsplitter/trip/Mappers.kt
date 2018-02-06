package io.github.gianpamx.tripsplitter.trip

import io.github.gianpamx.tripsplitter.entity.Trip

object Mappers {
    fun mapTripModel(trip: Trip) = TripModel(
            name = trip.name,
            pictureUrl = trip.picture.url
    )
}
