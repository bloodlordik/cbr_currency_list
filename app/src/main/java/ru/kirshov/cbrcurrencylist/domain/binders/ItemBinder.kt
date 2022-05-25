package ru.kirshov.cbrcurrencylist.domain.binders

import ru.kirshov.cbrcurrencylist.data.dto.CBRItemDto
import ru.kirshov.cbrcurrencylist.domain.story.CurrencyItem

fun CBRItemDto.toCurrencyItem():CurrencyItem{
    return CurrencyItem(
        id = this.id,
        charCode = this.charCode,
        title = this.name,
        value = this.value,
        nominal = this.nominal
    )
}