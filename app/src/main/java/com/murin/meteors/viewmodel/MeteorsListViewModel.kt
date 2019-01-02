package com.murin.meteors.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.murin.meteors.data.Meteor
import com.murin.meteors.data.MeteorsRepository

class MeteorsListViewModel internal constructor(
    private val meteorsRepository: MeteorsRepository
) : ViewModel() {

    private val meteors = MutableLiveData<List<Meteor>>()

    init {
        meteors.value = meteorsRepository.getMeteors().value
    }

    fun getMeteors() = meteors
}