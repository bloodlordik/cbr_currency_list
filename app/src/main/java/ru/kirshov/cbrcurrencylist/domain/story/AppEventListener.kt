package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow

interface AppEventListener<T> {
    val events:Flow<T>
}