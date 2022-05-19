package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AppErrors<T> {
    val error:Flow<T>
}

class AppErrorController<T>(initial:T): AppErrors<T> {
    private val errors = MutableStateFlow<T>(initial)
    fun add(value:T){
        errors.value = value
    }
    override val error: Flow<T>
        get() = errors
}