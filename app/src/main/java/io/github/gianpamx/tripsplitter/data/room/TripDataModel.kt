package io.github.gianpamx.tripsplitter.data.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "trip")
class TripDataModel {
    @PrimaryKey
    var id: String = ""

    @ColumnInfo(name = "name")
    var name: String = ""
}
