package ru.kirshov.cbrcurrencylist.domain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ApplicationViewModelFactory(
    private val context: Context,
    private val mainViewModel: MainViewModel
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(ErrorViewModel::class.java) -> ErrorViewModel()
            modelClass.isAssignableFrom(MainViewModel::class.java)->mainViewModel
            modelClass.isAssignableFrom(RootViewModel::class.java)->RootViewModel()
            else -> {
                throw IllegalArgumentException()
            }
        } as T
    }
}