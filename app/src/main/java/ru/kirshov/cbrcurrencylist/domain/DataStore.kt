package ru.kirshov.cbrcurrencylist.domain

import kotlinx.coroutines.flow.Flow
import ru.kirshov.cbrcurrencylist.domain.story.AppDataInfo
import ru.kirshov.cbrcurrencylist.domain.story.CurrencyItem

interface DataStore {
    val data:Flow<List<CurrencyItem>>
    val info:Flow<AppDataInfo>
}