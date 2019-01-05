package com.murin.meteors.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.murin.meteors.data.MeteorsRepository

class MeteorLandingMapViewModelFactory(
    private val meteorId: Int,
    private val meteorsRepository: MeteorsRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MeteorLandingMapViewModel(meteorId, meteorsRepository) as T
}
