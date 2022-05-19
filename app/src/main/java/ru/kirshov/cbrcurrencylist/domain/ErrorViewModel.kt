package ru.kirshov.cbrcurrencylist.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.kirshov.cbrcurrencylist.domain.story.AppError
import ru.kirshov.cbrcurrencylist.domain.story.AppErrors
import ru.kirshov.cbrcurrencylist.domain.story.AppEvents

class ErrorViewModel(
    private val error:AppErrors<AppError>
):ViewModel() {
    val errorTitle = error.error.map { it.error }.asLiveData()
}