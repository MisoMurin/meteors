package com.murin.meteors.data

import androidx.lifecycle.MutableLiveData
import com.murin.meteors.data.db.MeteorDao
import com.murin.meteors.data.network.RetrofitFactory

class MeteorsRepository private constructor(private val meteorDao: MeteorDao) {
    val fetchStatus = MutableLiveData<FetchStatus>()

    fun getMeteorById(meteorId: String) = meteorDao.getMeteorById(meteorId)

    fun getDbLiveMeteors() = meteorDao.getMeteors()

    fun fetchMeteorsFromApi() =
        try {
            println("mmeteors: fetching")
            fetchStatus.postValue(FetchStatus.FETCHING)
            RetrofitFactory.createRetrofitService().getMeteorLandings().execute()
                .run {
                    if (isSuccessful) {
                        meteorDao.insertAll(body() ?: emptyList())
                        fetchStatus.postValue(FetchStatus.SUCCESS)
                        true
                    } else {
                        fetchStatus.postValue(FetchStatus.FAILURE)
                        false
                    }
                }

        } catch (e: Exception) {
            e.printStackTrace()
            fetchStatus.postValue(FetchStatus.FAILURE)
            false
        }

    companion object {
        @Volatile private var instance: MeteorsRepository? = null

        fun getInstance(meteorDao: MeteorDao) =
            instance ?: synchronized(this) {
                instance ?: MeteorsRepository(meteorDao).also { instance = it }
            }
    }

    enum class FetchStatus {
        SUCCESS(),
        FETCHING(),
        FAILURE()
    }
}
