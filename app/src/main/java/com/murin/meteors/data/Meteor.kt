package com.murin.meteors.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meteors")
data class Meteor(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    val name: String,
    @ColumnInfo(name = "nametype")
    val nameType: String,
    val mass: Float,
    @ColumnInfo(name = "recclass")
    val recClass: String,
    @ColumnInfo(name = "reclat")
    val recLat: Float,
    @ColumnInfo(name = "reclong")
    val recLng: Float,
    val year: Int,
    val fall: String,
    @Embedded
    val geolocation: Geolocation
) {
    data class Geolocation(
        val type: String,
        val lat: Float,
        val lng: Float
    )

    fun massKg() = "${mass / 1000f} kg"

    fun hasLandingLocation() = geolocation.run { lat != 0.0f && lng != 0.0f }
}
