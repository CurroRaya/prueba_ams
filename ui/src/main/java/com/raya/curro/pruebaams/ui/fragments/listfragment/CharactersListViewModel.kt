package com.raya.curro.pruebaams.ui.fragments.listfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.domain.usecase.network.GetCharactersPageUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class CharactersListViewModel(private val getCharactersPage: GetCharactersPageUseCase) :
    ViewModel() {

    val characterList: StateFlow<PagingData<Result>> =
        getData().stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    private fun getData() = getCharactersPage.execute().cachedIn(viewModelScope)
}