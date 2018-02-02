package io.github.gianpamx.tripsplitter.usecase

import io.github.gianpamx.tripsplitter.entity.Picture
import io.github.gianpamx.tripsplitter.entity.Trip

class GetAllTripsUseCase {
    fun execute(success: (List<Trip>) -> Unit) {
        val trips = ArrayList<Trip>()
        trips.add(Trip(name = "Barcelona", picture = Picture("https://www.fattiretours.com/uploads/2208/barcelona%20hero.png", width = 1440, height = 675)))
        trips.add(Trip(name = "Paris", picture = Picture("http://www.clermont-aeroport.com/sites/default/files/styles/libre/public/destinations/paris.jpg?itok=BTUDwb6g", width = 3744, height = 5616)))
        trips.add(Trip(name = "Tokyo", picture = Picture("http://www.obayashi.co.jp/english/works/uploaded_attachment/page/main_image/largest/7/9/94a36b85-e9eb-45b7-983d-37130280c290.jpg", width = 472, height = 610)))
        trips.add(Trip(name = "Muchu Picchu", picture = Picture("http://www.robertodemicheli.com/album_test/Peru/Machu%20Picchu/slides/IMG_5162.jpg", width = 690, height = 1024)))
        trips.add(Trip(name = "Munich", picture = Picture("https://cache-graphicslib.viator.com/graphicslib/thumbs360x240/2666/SITours/private-munich-old-town-walking-tour-in-munich-146517.jpg", width = 360, height = 240)))
        success.invoke(trips)
    }
}
