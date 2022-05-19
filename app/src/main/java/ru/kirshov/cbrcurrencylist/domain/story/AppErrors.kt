package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow

interface AppErrors<T> {
    val error:Flow<T>
}