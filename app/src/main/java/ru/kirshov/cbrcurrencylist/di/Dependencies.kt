

package ru.kirshov.cbrcurrencylist.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.kirshov.cbrcurrencylist.data.repository.CbrRepository

class Dependencies(val appContext: Context) {
    private val baseUrl = "https://www.cbr-xml-daily.ru/"
    private fun getOkHttp():OkHttpClient{
        return OkHttpClient.Builder().build()
    }
    fun getCbrRetrofitClient():CbrRepository{
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .client(getOkHttp())
            .baseUrl(baseUrl)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create(CbrRepository::class.java)
    }
}