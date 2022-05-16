package ru.kirshov.cbrcurrencylist.data.repository

import retrofit2.http.GET
import ru.kirshov.cbrcurrencylist.data.dto.CBRListItemDto
private const val url ="daily_json.js"
interface CbrRepository {
    @GET(url)
    suspend fun getCurrencyList():CBRListItemDto
}