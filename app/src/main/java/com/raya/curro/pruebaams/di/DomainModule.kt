package com.raya.curro.pruebaams.di

import com.raya.curro.pruebaams.domain.usecase.local.CheckIdUseCase
import com.raya.curro.pruebaams.domain.usecase.local.SaveIdsUseCase
import com.raya.curro.pruebaams.domain.usecase.network.GetCharactersPageUseCase
import com.raya.curro.pruebaams.domain.usecase.network.GetFavoriteCharactersUseCase
import com.raya.curro.pruebaams.domain.usecase.network.SearchCharactersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetCharactersPageUseCase(get())
    }
    factory {
        SearchCharactersUseCase(get())
    }
    factory {
        GetFavoriteCharactersUseCase(storage = get(), networkRepository = get())
    }
    factory {
        CheckIdUseCase(storage = get())
    }
    factory {
        SaveIdsUseCase(get())
    }
}