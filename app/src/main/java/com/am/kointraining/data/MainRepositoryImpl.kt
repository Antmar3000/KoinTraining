package com.am.kointraining.data

import android.util.Log
import com.am.kointraining.data.api.KtorApi
import com.am.kointraining.data.api.RemoteApi
import com.am.kointraining.data.entity.RemoteEntity
import com.am.kointraining.domain.MainRepository
import io.ktor.client.call.body

class MainRepositoryImpl(
    private val api: RemoteApi,
    private val ktorApi: KtorApi
) : MainRepository {

    override suspend fun doNetworkCall(): RemoteEntity {
        Log.d("myLog", "Retrofit2")
        return api.callApi()
    }

    override suspend fun doKtorCall(): Result<RemoteEntity> =
        kotlin.runCatching {
            val result = ktorApi.ktorGetProducts().body<RemoteEntity>()
            result
        }
}




