package com.raya.curro.pruebaams.domain.repository

interface StorageRepository {

    fun saveIds(list: List<String>)

    fun getIds(): List<String>?
}