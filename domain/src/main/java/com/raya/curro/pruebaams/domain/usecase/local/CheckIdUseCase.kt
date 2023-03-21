package com.raya.curro.pruebaams.domain.usecase.local

import com.raya.curro.pruebaams.domain.repository.StorageRepository

class CheckIdUseCase(private val storage: StorageRepository) {
    fun execute(id: Int): Boolean {
        val ids = storage.getIds() ?: emptyList()
        ids.map { if (id.toString() == it) return true }
        return false
    }
}