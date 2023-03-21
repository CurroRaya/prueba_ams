package com.raya.curro.pruebaams.ui.fragments.detailfragment

import androidx.lifecycle.ViewModel
import com.raya.curro.pruebaams.domain.usecase.local.CheckIdUseCase
import com.raya.curro.pruebaams.domain.usecase.local.SaveIdsUseCase

class DetailInformationViewModel(
    private val isFavorite: CheckIdUseCase,
    private val saveId: SaveIdsUseCase
) : ViewModel() {

    fun isFavoriteCheck(id: Int) = isFavorite.execute(id)

    fun clickOnLike(id: Int) = saveId.execute(id)
}