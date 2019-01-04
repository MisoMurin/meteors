package com.murin.meteors.viewmodel

import androidx.lifecycle.ViewModel
import com.murin.meteors.data.MeteorsRepository

class MeteorLandingMapViewModel internal constructor(
    meteorId: String,
    meteorsRepository: MeteorsRepository
) : ViewModel() {
    private val meteor = meteorsRepository.getMeteorById(meteorId)

    fun getMeteor() = meteor
}
