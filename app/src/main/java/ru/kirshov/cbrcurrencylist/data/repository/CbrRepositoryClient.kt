package ru.kirshov.cbrcurrencylist.data.repository

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit


class CbrRepositoryClient() {
    private val baseUrl = "https://www.cbr-xml-daily.ru/"
    private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
    private val client = OkHttpClient.Builder().build()
    fun getRepository(): CbrRepository {
        val contentType = "application/json".toMediaType()
        return retrofit.client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build().create(CbrRepository::class.java)
    }
}

