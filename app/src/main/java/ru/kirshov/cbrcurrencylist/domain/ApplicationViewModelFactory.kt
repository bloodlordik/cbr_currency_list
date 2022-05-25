package ru.kirshov.cbrcurrencylist.domain

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kirshov.cbrcurrencylist.data.dispatchers.AppDispatchers

class ApplicationViewModelFactory(

    private val mainViewModel: MainViewModel,
    private val dataStore: DataStore,
    private val errorStore: ErrorStore,
    private val dispatchers: AppDispatchers
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(ErrorViewModel::class.java) -> ErrorViewModel(errorStore)
            modelClass.isAssignableFrom(MainViewModel::class.java)->mainViewModel
            modelClass.isAssignableFrom(RootViewModel::class.java)->RootViewModel(dataStore)
            else -> {
                throw IllegalArgumentException()
            }
        } as T
    }
}