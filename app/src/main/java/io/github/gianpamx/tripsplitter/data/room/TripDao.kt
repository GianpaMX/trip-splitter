package io.github.gianpamx.tripsplitter.data.room

import android.arch.persistence.room.*

@Dao
interface TripDao {
    @Insert()
    fun insert(trip: TripDataModel)

    @Update()
    fun update(trip: TripDataModel)

    @Query("SELECT * FROM trip WHERE id = :id")
    fun findById(id: String): TripDataModel?

    @Query("SELECT * FROM trip")
    fun findAll(): List<TripDataModel>

    @Delete
    fun delete(trip: TripDataModel)
}
