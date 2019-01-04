package com.murin.meteors.data.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun listOfFloatsToString(value: List<Float>): String =
        value.joinToString(",")

    @TypeConverter
    fun stringToListOfFloats(value: String): List<Float> =
        value.split(",").map { it.toFloat() }
}
