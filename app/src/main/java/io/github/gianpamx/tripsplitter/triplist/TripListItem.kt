package io.github.gianpamx.tripsplitter.triplist

import java.util.*

data class TripListItem(
        var id: String = "",
        var name: String = "",
        var pictureUrl: String = "",
        var pictureOrientation: Int = 0,
        var startDate: Date = Date(),
        var days: Int = 0
) {
    companion object {
        val PORTRAIT = 0
        val LANDSCAPE = 1
    }
}
