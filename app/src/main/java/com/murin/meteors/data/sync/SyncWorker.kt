package com.murin.meteors.data.sync

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.murin.meteors.Provider
import com.murin.meteors.isOnline

class SyncWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return if (applicationContext.isOnline()) {
            println("mmeteors: meteors sync start")
            Provider
                .getMeteorsRepository(applicationContext)
                .fetchMeteorsFromApi()
                .let { success ->
                    if (success) {
                        println("mmeteors: meteors sync success")
                        Result.success()
                    } else {
                        println("mmeteors: meteors sync failure")
                        Result.failure()
                    }
                }
        } else {
            println("mmeteors: meteors sync aborted - offline")
            Result.failure()
        }
    }
}
