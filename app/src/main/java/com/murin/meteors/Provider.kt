package com.murin.meteors

import com.murin.meteors.viewmodel.MeteorsListViewModelFactory

object Provider {
    fun provideMeteorsListViewModelFactory(): MeteorsListViewModelFactory {
        return MeteorsListViewModelFactory()
    }
}