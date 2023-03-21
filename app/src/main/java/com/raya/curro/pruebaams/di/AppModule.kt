package com.raya.curro.pruebaams.di

import com.raya.curro.pruebaams.ui.fragments.detailfragment.DetailInformationViewModel
import com.raya.curro.pruebaams.ui.fragments.favoritesfragment.FavoritesViewModel
import com.raya.curro.pruebaams.ui.fragments.listfragment.CharactersListViewModel
import com.raya.curro.pruebaams.ui.fragments.searchfragment.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        CharactersListViewModel(get())
    }
    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        FavoritesViewModel(get())
    }
    viewModel {
        DetailInformationViewModel(
            saveId = get(),
            isFavorite = get()
        )
    }
}