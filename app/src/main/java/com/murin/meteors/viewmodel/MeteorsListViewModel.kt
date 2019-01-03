package com.murin.meteors.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.murin.meteors.data.Meteor
import com.murin.meteors.data.MeteorsRepository

class MeteorsListViewModel internal constructor(
    private val meteorsRepository: MeteorsRepository
) : ViewModel() {
    private val meteors = MediatorLiveData<List<Meteor>>()

    init {
        val dbMeteors = meteorsRepository.getDbLiveMeteors()
        meteors.addSource(dbMeteors, meteors::setValue)
    }

    fun getMeteors() = meteors

    fun fetchMeteors() = meteorsRepository.fetchMeteorsFromApi()
}
