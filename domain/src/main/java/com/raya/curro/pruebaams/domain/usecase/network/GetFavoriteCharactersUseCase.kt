package com.raya.curro.pruebaams.domain.usecase.network

import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.domain.model.network.FavoritesResult
import com.raya.curro.pruebaams.domain.repository.NetworkRepository
import com.raya.curro.pruebaams.domain.repository.StorageRepository

class GetFavoriteCharactersUseCase(
    private val storage: StorageRepository,
    private val networkRepository: NetworkRepository
) {
    suspend fun execute(): FavoritesResult<List<Result>> {
        val ids = storage.getIds() ?: emptyList()
        if (ids.isEmpty()) return FavoritesResult.Success(emptyList())
        val path = StringBuilder("")
        ids.map { path.append("$it,") }
        return networkRepository.getCharactersByIds(path.toString())
    }
}