package com.murin.meteors.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "meteors")
data class Meteor(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: String,
    val name: String?,
    @field:Json(name = "nametype")
    @ColumnInfo(name = "nametype")
    val nameType: String?,
    val mass: String?,
    @field:Json(name = "recclass")
    @ColumnInfo(name = "recclass")
    val recClass: String?,
    @field:Json(name = "reclat")
    @ColumnInfo(name = "reclat")
    val recLat: String?,
    @field:Json(name = "reclong")
    @ColumnInfo(name = "reclong")
    val recLng: String?,
    val year: String?,
    val fall: String?,
    @Embedded
    val geolocation: Geolocation?
) {
    data class Geolocation(
        val type: String,
        val coordinates: List<Float>
    )

    fun massKgString() = "${(mass?.toFloat() ?: 0f) / 1000f} kg"

    fun yearAsNumber() = year?.substring(0, 4) ?: 0
}
