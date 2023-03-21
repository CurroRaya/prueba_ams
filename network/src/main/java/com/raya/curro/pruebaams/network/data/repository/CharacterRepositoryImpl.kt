package com.raya.curro.pruebaams.network.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.domain.model.network.FavoritesResult
import com.raya.curro.pruebaams.domain.repository.NetworkRepository
import com.raya.curro.pruebaams.network.data.api.ApiService
import com.raya.curro.pruebaams.network.data.paging.CharactersPagingSource
import com.raya.curro.pruebaams.network.data.utils.wrapper.FavoritesWrapper

class CharacterRepositoryImpl(private val apiService: ApiService) :
    NetworkRepository {

    override suspend fun getCharactersByIds(ids: String): FavoritesResult<List<Result>> =
        FavoritesWrapper.wrapInResult { apiService.getCharactersByIds(ids) }

    override fun fetchCharactersList(
        name: String?,
        gender: String?,
        status: String?,
    ) = Pager(PagingConfig(pageSize = 1, prefetchDistance = 20),
        pagingSourceFactory = { CharactersPagingSource(apiService, name, gender, status) }).flow
}