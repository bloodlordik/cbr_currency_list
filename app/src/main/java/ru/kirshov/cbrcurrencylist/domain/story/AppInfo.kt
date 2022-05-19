package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow

interface AppInfo<T> {
    val info:Flow<T>
}