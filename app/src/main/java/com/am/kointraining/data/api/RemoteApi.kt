package com.am.kointraining.data.api

import com.am.kointraining.data.entity.RemoteEntity
import retrofit2.http.GET

interface RemoteApi {

    @GET("products/1")
    suspend fun callApi () : RemoteEntity
}