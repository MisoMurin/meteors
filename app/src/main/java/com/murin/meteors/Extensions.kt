package com.murin.meteors

import android.content.Context
import android.net.ConnectivityManager

fun Context.isOnline(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo.let { networkInfo ->
        networkInfo != null && networkInfo.isConnected
    }
}
