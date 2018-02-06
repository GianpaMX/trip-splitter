package io.github.gianpamx.tripsplitter.usecase

import io.github.gianpamx.tripsplitter.entity.Picture
import io.github.gianpamx.tripsplitter.entity.Trip

class GetTripUseCase {
    fun execute(tripId: String, success: (trip: Trip) -> Unit) {
        success.invoke(Trip(name = "Tokyo", picture = Picture("http://www.obayashi.co.jp/english/works/uploaded_attachment/page/main_image/largest/7/9/94a36b85-e9eb-45b7-983d-37130280c290.jpg", width = 472, height = 610)))
    }
}
