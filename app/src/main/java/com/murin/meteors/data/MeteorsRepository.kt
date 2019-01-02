package com.murin.meteors.data

class MeteorsRepository private constructor(private val meteorDao: MeteorDao) {

    fun getMeteors() = meteorDao.getMeteors()

    companion object {
        @Volatile private var instance: MeteorsRepository? = null

        fun getInstance(meteorDao: MeteorDao) =
            instance ?: synchronized(this) {
                instance ?: MeteorsRepository(meteorDao).also { instance = it }
            }
    }
}