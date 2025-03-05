package com.am.kointraining.data.api

import android.util.Log
import com.am.kointraining.domain.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol

class KtorApi (private val httpClient: HttpClient) {


    suspend fun ktorGetProducts() : HttpResponse {
        Log.d("myLog", "ApiKtorCall")
        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = Constants.END_POINT_WITHOUT_HTTPS
            }
        }
        Log.d("myLog", response.toString())
        return response
    }
}