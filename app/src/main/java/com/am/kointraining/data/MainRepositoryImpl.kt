package com.am.kointraining.data

import android.util.Log
import com.am.kointraining.data.api.RemoteApi
import com.am.kointraining.domain.MainRepository

class MainRepositoryImpl (
    private val api : RemoteApi
) : MainRepository {

    override fun doNetworkCall() {
//        api.callApi()
        Log.d("myLog", "Smth")
    }
}