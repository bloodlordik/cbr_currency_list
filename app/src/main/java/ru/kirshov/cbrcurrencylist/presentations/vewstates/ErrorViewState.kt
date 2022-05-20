package ru.kirshov.cbrcurrencylist.presentations.vewstates

sealed interface ErrorViewState
object Loading:ErrorViewState
data class ShowError(
    val error:String
):ErrorViewState