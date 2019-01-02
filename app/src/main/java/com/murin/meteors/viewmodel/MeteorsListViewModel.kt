package com.murin.meteors.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.murin.meteors.data.Meteor

class MeteorsListViewModel : ViewModel() {

    private val meteors = MutableLiveData<List<Meteor>>()

    fun getMeteors() = meteors
}