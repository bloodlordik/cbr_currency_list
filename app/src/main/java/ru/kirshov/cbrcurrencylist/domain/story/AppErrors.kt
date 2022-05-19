package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AppErrors<T> {
    val error:Flow<T>
}

