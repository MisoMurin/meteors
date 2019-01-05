package com.murin.meteors.data.network

import com.murin.meteors.data.Meteor
import com.squareup.moshi.Json

data class MeteorApiModel(
    val id: String,
    val name: String?,
    @field:Json(name = "nametype")
    val nameType: String?,
    val mass: String?,
    @field:Json(name = "recclass")
    val recClass: String?,
    @field:Json(name = "reclat")
    val recLat: String?,
    @field:Json(name = "reclong")
    val recLng: String?,
    val year: String?,
    val fall: String?,
    val geolocation: Geolocation?
) {
    data class Geolocation(
        val type: String,
        val coordinates: List<Float>
    )

    fun toMeteor() = Meteor(
        id = id.toInt(),
        name = name ?: "",
        nameType = nameType ?: "",
        mass = mass?.toFloat() ?: 0f,
        recClass = recClass ?: "",
        recLat = recLat?.toFloat() ?: 0f,
        recLng = recLng?.toFloat() ?: 0f,
        year = year?.substring(0, 4)?.toInt() ?: 0,
        fall = fall ?: "",
        geolocation = Meteor.Geolocation(
            type = geolocation?.type ?: "",
            lat = geolocation?.coordinates?.get(1) ?: 0f,
            lng = geolocation?.coordinates?.get(0) ?: 0f
        )
    )
}
