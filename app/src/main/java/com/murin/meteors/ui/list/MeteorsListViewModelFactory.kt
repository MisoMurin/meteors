package com.murin.meteors.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.murin.meteors.data.MeteorsRepository

class MeteorsListViewModelFactory(
    private val meteorsRepository: MeteorsRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        MeteorsListViewModel(meteorsRepository) as T
}
