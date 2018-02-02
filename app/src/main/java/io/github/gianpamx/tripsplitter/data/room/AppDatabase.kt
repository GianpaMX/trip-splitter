package io.github.gianpamx.tripsplitter.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(TripDataModel::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao
}
