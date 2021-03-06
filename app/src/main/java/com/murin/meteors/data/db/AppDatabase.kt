package com.murin.meteors.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.murin.meteors.data.Meteor
import com.murin.meteors.data.sync.SyncDatabaseCallback

const val DATABASE_NAME = "meteors-db"

@Database(entities = [Meteor::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun meteorDao(): MeteorDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(SyncDatabaseCallback())
                .build()
        }
    }
}
