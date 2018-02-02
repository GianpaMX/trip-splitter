package io.github.gianpamx.tripsplitter.data.room

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.gianpamx.tripsplitter.data.Repository
import io.github.gianpamx.tripsplitter.entity.Trip

@Module
class RoomModule {
    @Provides
    fun providesAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "database").build()

    @Provides
    fun providesTripDao(database: AppDatabase) = database.tripDao()

    @Provides
    fun provideRepository(tripDao: TripDao): Repository<Trip> = TripRepository(tripDao)
}
