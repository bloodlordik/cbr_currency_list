package ru.kirshov.cbrcurrencylist.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import ru.kirshov.cbrcurrencylist.domain.story.AppError

interface ErrorStore{
    val errors:Flow<AppError>
    suspend fun update(dispatcher: CoroutineDispatcher)
}