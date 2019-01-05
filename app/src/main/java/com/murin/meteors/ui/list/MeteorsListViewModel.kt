package com.murin.meteors.ui.list

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.murin.meteors.data.Meteor
import com.murin.meteors.data.MeteorsRepository

class MeteorsListViewModel internal constructor(
    private val meteorsRepository: MeteorsRepository
) : ViewModel() {
    val meteors = MediatorLiveData<List<Meteor>>()
    val fetchStatus = MutableLiveData<MeteorsRepository.FetchStatus>()

    init {
        val dbMeteors = meteorsRepository.getDbLiveMeteors()
        meteors.addSource(dbMeteors, meteors::setValue)
    }

    fun fetchMeteors() = meteorsRepository.fetchMeteorsFromApi(fetchStatus)
}
