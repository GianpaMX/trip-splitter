package io.github.gianpamx.tripsplitter.triplist

import io.github.gianpamx.tripsplitter.entity.Trip
import io.github.gianpamx.tripsplitter.triplist.TripListItem.Companion.LANDSCAPE
import io.github.gianpamx.tripsplitter.triplist.TripListItem.Companion.PORTRAIT

object Mappers {
    fun mapTripListItem(trip: Trip) = TripListItem(
            trip.id,
            trip.name,
            trip.picture.url,
            if (trip.picture.width / trip.picture.height >= 1) LANDSCAPE else PORTRAIT,
            trip.startDate,
            trip.length
    )
}
