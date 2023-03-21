package com.raya.curro.pruebaams.domain.repository

import androidx.paging.PagingData
import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.domain.model.network.FavoritesResult
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    suspend fun getCharactersByIds(ids: String): FavoritesResult<List<Result>>

    fun fetchCharactersList(
        name: String? = null,
        gender: String? = null,
        status: String? = null,
    ): Flow<PagingData<Result>>
}