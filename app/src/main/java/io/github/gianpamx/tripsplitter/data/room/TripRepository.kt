package io.github.gianpamx.tripsplitter.data.room

import io.github.gianpamx.tripsplitter.data.Repository
import io.github.gianpamx.tripsplitter.data.room.Mappers.mapTrip
import io.github.gianpamx.tripsplitter.data.room.Mappers.mapTripDataModel
import io.github.gianpamx.tripsplitter.entity.Trip
import kotlin.concurrent.thread

class TripRepository(val dao: TripDao) : Repository<Trip> {
    override fun create(item: Trip, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        thread { createSync(item, success, failure) }
    }

    fun createSync(trip: Trip, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        dao.insert(mapTripDataModel(trip))

        success.invoke()
    }

    override fun retrieve(id: String, success: (item: Trip) -> Unit, failure: (throwable: Throwable) -> Unit) {
        thread { retrieveSync(id, success, failure) }
    }

    fun retrieveSync(id: String, success: (item: Trip) -> Unit, failure: (throwable: Throwable) -> Unit) {
        val tripDataModel = dao.findById(id)
        if (tripDataModel == null) {
            failure.invoke(Repository.NotFoundException("Trip with id '$id' not found"))
            return
        }

        success.invoke(mapTrip(tripDataModel))
    }

    override fun update(item: Trip, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        thread { updateSync(item, success, failure) }
    }

    fun updateSync(trip: Trip, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        dao.update(mapTripDataModel(trip))

        success.invoke()
    }

    override fun delete(id: String, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        thread { deleteSync(id, success, failure) }
    }

    fun deleteSync(id: String, success: () -> Unit, failure: (throwable: Throwable) -> Unit) {
        val tripDataModel = dao.findById(id)
        if (tripDataModel == null) {
            failure.invoke(Repository.NotFoundException("Trip with id '$id' not found"))
            return
        }

        dao.delete(tripDataModel)

        success.invoke()
    }

    override fun retrieveAll(success: (items: List<Trip>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        thread { retrieveAllSync(success, failure) }
    }

    fun retrieveAllSync(success: (items: List<Trip>) -> Unit, failure: (throwable: Throwable) -> Unit) {
        val all = dao.findAll()
        val trips = ArrayList<Trip>(all.size)

        for (tripDataModel in all) {
            trips.add(mapTrip(tripDataModel))
        }

        success.invoke(trips)
    }
}
