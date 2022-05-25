package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import kotlinx.coroutines.Dispatchers
import ru.kirshov.cbrcurrencylist.data.dispatchers.AppDispatchers
import ru.kirshov.cbrcurrencylist.domain.ApplicationViewModelFactory
import ru.kirshov.cbrcurrencylist.domain.MainViewModel
import ru.kirshov.cbrcurrencylist.domain.story.AppRepository
import ru.kirshov.cbrcurrencylist.domain.story.AppState

class MainApplication : Application() {

    val viewModelFactory by lazy {
        ApplicationViewModelFactory(appState!!, appRepository, appRepository, appDispatchers)
    }
    private val appDispatchers by lazy { AppDispatchers(
        io = Dispatchers.IO,
        main = Dispatchers.Main
    ) }
    private val appRepository by lazy { AppRepository() }
    private var appState: MainViewModel? = null
    override fun onCreate() {
        super.onCreate()
        appState = MainViewModel(appRepository = appRepository, dispatchers = appDispatchers)

    }

    override fun onTerminate() {
        super.onTerminate()
        appState = null
    }
}

val Context.factory: ApplicationViewModelFactory
    get() {
        return (this.applicationContext as MainApplication).viewModelFactory
    }