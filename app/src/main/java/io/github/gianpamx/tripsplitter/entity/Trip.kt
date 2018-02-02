package io.github.gianpamx.tripsplitter.entity

import java.util.*
import java.util.Calendar.DAY_OF_MONTH

data class Trip(
        var id: String = "",
        var name: String = "",
        var picture: Picture = Picture(),
        var startDate: Date = Date(),
        var endDate: Date = Date()
) {
    val length: Int
        get() {
            var days = 1
            val start = Calendar.getInstance()
            start.timeInMillis = startDate.time
            while (start.before(endDate)) {
                start.add(DAY_OF_MONTH, 1)
                days++
            }
            return days
        }
}
