package com.murin.meteors.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meteors")
data class Meteor(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: String,
    val name: String,
    @ColumnInfo(name = "name_type")
    val nameType: String,
    @ColumnInfo(name = "rec_class")
    val recClass: String,
    @ColumnInfo(name = "name_lat")
    val recLat: String,
    @ColumnInfo(name = "name_lng")
    val recLng: String,
    val year: String,
    val fall: String,
    @Embedded
    val geolocation: Geolocation
) {
    data class Geolocation(
        val type: String,
        val coordinates: List<Float>
    )
}