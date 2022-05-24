package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow

interface BaseRepository<T,S,E>{
    suspend fun update():Unit
    val data:Flow<T>
    val error:Flow<E>
    val appState:Flow<S>
}