package com.murin.meteors.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.murin.meteors.data.MeteorsRepository

class MeteorLandingMapViewModelFactory(
    private val meteorId: String,
    private val meteorsRepository: MeteorsRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MeteorLandingMapViewModel(meteorId, meteorsRepository) as T
}
