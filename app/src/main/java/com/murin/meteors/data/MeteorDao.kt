package com.murin.meteors.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MeteorDao {
    @Query("SELECT * FROM meteors")
    fun getMeteors(): LiveData<List<Meteor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(meteors: List<Meteor>)
}