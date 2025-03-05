package com.am.kointraining.domain

import com.am.kointraining.data.entity.RemoteEntity

interface MainRepository {

    suspend fun doNetworkCall() : RemoteEntity

    suspend fun doKtorCall() : Result<RemoteEntity>
}