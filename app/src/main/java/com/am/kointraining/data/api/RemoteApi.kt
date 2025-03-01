package com.am.kointraining.data.api

import retrofit2.http.GET

interface RemoteApi {

    @GET("my/endpoint")
    fun callApi ()
}