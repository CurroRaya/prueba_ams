package com.raya.curro.pruebaams.domain.usecase.network

import com.raya.curro.pruebaams.domain.repository.NetworkRepository

class SearchCharactersUseCase(private val repository: NetworkRepository) {

    fun execute(name: String?, gender: String?, status: String?) =
        repository.fetchCharactersList(name = name, gender = gender, status = status)
}