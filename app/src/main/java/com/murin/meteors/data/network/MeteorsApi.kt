package com.murin.meteors.data.network

import com.murin.meteors.xAppToken
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MeteorsApi {
    @Headers("X-App-Token: $xAppToken")
    @GET("y77d-th95.json")
    fun getMeteorLandings(
        @Query(value = "\$where") year: String,
        @Query(value = "\$limit") limit: Int,
        @Query(value = "\$offset") offset: Int
    ): Call<List<MeteorApiModel>>
}
