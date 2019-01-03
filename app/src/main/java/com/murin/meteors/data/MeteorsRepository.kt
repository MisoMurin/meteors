package com.murin.meteors.data

import com.murin.meteors.network.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MeteorsRepository private constructor(private val meteorDao: MeteorDao) {

    fun getMeteorById(meteorId: String) = meteorDao.getMeteorById(meteorId)

    fun getDbLiveMeteors() = meteorDao.getMeteors()

    fun fetchMeteorsFromApi() = GlobalScope.launch(Dispatchers.IO) {
        val meteors = RetrofitFactory
            .createRetrofitService()
            .getMeteorLandings()
            .await()
            .filter { it.year?.substring(0, 4)?.toInt() ?: 0 >= 2011}
            .sortedBy { it.mass?.toFloat() }

        if (meteors.isNotEmpty()) {
            meteorDao.insertAll(meteors)
        }
    }

    companion object {
        @Volatile private var instance: MeteorsRepository? = null

        fun getInstance(meteorDao: MeteorDao) =
            instance ?: synchronized(this) {
                instance ?: MeteorsRepository(meteorDao).also { instance = it }
            }
    }
}
