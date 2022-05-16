package ru.kirshov.cbrcurrencylist.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CBRListItemDto(
    @SerialName("Date")
    val date: String,
    @SerialName("PreviousDate")
    val previousDate: String,
    @SerialName("PreviousURL")
    val previousURL: String,
    @SerialName("Timestamp")
    val timestamp: String,
    @SerialName("Valute")
    val currencyList:Map<String,CBRItemDto>
)
