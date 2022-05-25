package ru.kirshov.cbrcurrencylist.domain.binders

import ru.kirshov.cbrcurrencylist.data.dto.CBRListItemDto
import ru.kirshov.cbrcurrencylist.domain.story.AppDataInfo

fun CBRListItemDto.toInfo():AppDataInfo{
    return AppDataInfo(
        date = this.date,
        previousDate = this.previousDate,
        previousURL = this.previousURL,
        timestamp = this.timestamp
    )
}