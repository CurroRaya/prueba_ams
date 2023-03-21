package com.raya.curro.pruebaams.di

import com.raya.curro.pruebaams.network.data.api.ApiService
import com.raya.curro.pruebaams.network.data.paging.CharactersPagingSource
import com.raya.curro.pruebaams.network.data.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Constants.CHARACTER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        CharactersPagingSource(api = get())
    }
}