package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.flow.Flow

interface AppData {
    val data:Flow<List<CurrencyItem>>
    fun updateData()
}