package com.raya.curro.pruebaams.di

import com.raya.curro.pruebaams.domain.repository.NetworkRepository
import com.raya.curro.pruebaams.domain.repository.StorageRepository
import com.raya.curro.pruebaams.network.data.repository.CharacterRepositoryImpl
import com.raya.curro.pruebaams.storage.preferences.UserPreferencesImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<NetworkRepository> {
        CharacterRepositoryImpl(apiService = get())
    }

    single<StorageRepository> {
        UserPreferencesImpl(context = get())
    }
}