package ru.kirshov.cbrcurrencylist.domain.story

data class CurrencyItem(
    val id: String,
    val charCode: String,
    val title: String,
    val value: Double,
    val nominal: Int
)
