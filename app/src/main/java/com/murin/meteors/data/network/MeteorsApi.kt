package com.murin.meteors.data.network

import com.murin.meteors.data.Meteor
import com.murin.meteors.xAppToken
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MeteorsApi {
    @Headers("X-App-Token: $xAppToken")
    @GET("y77d-th95.json")
    fun getMeteorLandings(): Call<List<Meteor>>
}
