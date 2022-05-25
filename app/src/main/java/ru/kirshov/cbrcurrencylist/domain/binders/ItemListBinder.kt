package ru.kirshov.cbrcurrencylist.domain.binders

import ru.kirshov.cbrcurrencylist.data.dto.CBRListItemDto
import ru.kirshov.cbrcurrencylist.domain.story.CurrencyItem

fun CBRListItemDto.toList():List<CurrencyItem>{
    if (this.currencyList.isEmpty()) return emptyList()
    return this.currencyList.values.map { it.toCurrencyItem() }
}