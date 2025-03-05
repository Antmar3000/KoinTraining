package com.am.kointraining.di

import com.am.kointraining.data.MainRepositoryImpl
import com.am.kointraining.data.api.KtorApi
import com.am.kointraining.data.api.RemoteApi
import com.am.kointraining.domain.Constants
import com.am.kointraining.domain.MainRepository
import com.am.kointraining.presentation.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteApi::class.java)
    }

    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json {
                    prettyPrint = true
                    isLenient = true
                    useAlternativeNames = true
                    ignoreUnknownKeys = true
                    encodeDefaults = false
                },
                    contentType = ContentType.Any
                )
            }
        }
    }

    single<KtorApi>{KtorApi(get())}


    /**
     * do not forget to use { bind <T-interface>() } after singleOf(::T-impl)
     */
    singleOf(::MainRepositoryImpl) { bind<MainRepository>()}

    viewModelOf(::MainViewModel)
}