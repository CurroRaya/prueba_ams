package com.raya.curro.pruebaams.network.data.utils.wrapper

import com.raya.curro.pruebaams.domain.model.Result
import com.raya.curro.pruebaams.domain.model.network.FavoritesResult
import java.net.UnknownHostException

object FavoritesWrapper {

    suspend fun wrapInResult(request: suspend () -> List<Result>): FavoritesResult<List<Result>> {
        return try {
            val value = request()
            if (value.isEmpty() || value.none()) {
                FavoritesResult.Success(emptyList())
            } else {
                FavoritesResult.Success(value)
            }
        } catch (e: UnknownHostException) {
            FavoritesResult.ConnectionError
        } catch (e: Throwable) {
            FavoritesResult.Error(e)
        }
    }
}