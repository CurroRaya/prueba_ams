package com.raya.curro.pruebaams.domain.usecase.network

import com.raya.curro.pruebaams.domain.repository.NetworkRepository

class GetCharactersPageUseCase(private val repository: NetworkRepository) {

    fun execute() = repository.fetchCharactersList()
}