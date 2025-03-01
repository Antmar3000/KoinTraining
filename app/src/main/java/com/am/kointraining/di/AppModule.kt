package com.am.kointraining.di

import com.am.kointraining.data.MainRepositoryImpl
import com.am.kointraining.data.api.RemoteApi
import com.am.kointraining.domain.Constants
import com.am.kointraining.domain.MainRepository
import com.am.kointraining.presentation.MainViewModel
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


    /**
     * do not forget to use { bind <T-interface>() } after singleOf(::T-impl)
     */
    singleOf(::MainRepositoryImpl) { bind<MainRepository>()}

    viewModelOf(::MainViewModel)
}