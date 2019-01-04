package com.murin.meteors

import android.content.Context
import com.murin.meteors.data.AppDatabase
import com.murin.meteors.data.MeteorsRepository
import com.murin.meteors.viewmodel.MeteorLandingMapViewModelFactory
import com.murin.meteors.viewmodel.MeteorsListViewModelFactory

object Provider {
    private fun getMeteorsRepository(context: Context): MeteorsRepository {
        return MeteorsRepository.getInstance(AppDatabase.getInstance(context).meteorDao())
    }

    fun provideMeteorsListViewModelFactory(context: Context): MeteorsListViewModelFactory {
        val repository = getMeteorsRepository(context)
        return MeteorsListViewModelFactory(repository)
    }

    fun provideMeteorLandingMapViewModelFactory(meteorId: String, context: Context): MeteorLandingMapViewModelFactory {
        val repository = getMeteorsRepository(context)
        return MeteorLandingMapViewModelFactory(meteorId, repository)
    }
}
