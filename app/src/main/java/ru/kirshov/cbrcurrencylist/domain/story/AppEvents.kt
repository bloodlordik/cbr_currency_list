package ru.kirshov.cbrcurrencylist.domain.story

sealed interface AppEvents

object Loading:AppEvents
object Done:AppEvents
object Error:AppEvents

