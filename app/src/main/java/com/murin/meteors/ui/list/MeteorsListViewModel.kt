package com.murin.meteors.ui.list

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.murin.meteors.data.Meteor
import com.murin.meteors.data.MeteorsRepository

class MeteorsListViewModel internal constructor(
    meteorsRepository: MeteorsRepository
) : ViewModel() {
    val meteors = MediatorLiveData<List<Meteor>>()
    val fetchStatus = meteorsRepository.fetchStatus

    init {
        val dbMeteors = meteorsRepository.getDbLiveMeteors()
        meteors.addSource(dbMeteors, meteors::setValue)
    }
}
