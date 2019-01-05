package com.murin.meteors.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.murin.meteors.data.Meteor

@Dao
interface MeteorDao {
    @Query("SELECT * FROM meteors")
    fun getMeteors(): LiveData<List<Meteor>>

    @Query("SELECT * FROM meteors WHERE id = :meteorId")
    fun getMeteorById(meteorId: Int): LiveData<List<Meteor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(meteors: List<Meteor>)
}
