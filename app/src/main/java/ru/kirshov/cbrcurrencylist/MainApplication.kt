package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import ru.kirshov.cbrcurrencylist.domain.ApplicationViewModelFactory
import ru.kirshov.cbrcurrencylist.domain.MainViewModel
import ru.kirshov.cbrcurrencylist.domain.story.AppRepository
import ru.kirshov.cbrcurrencylist.domain.story.AppState

class MainApplication : Application() {

    val viewModelFactory by lazy {
        ApplicationViewModelFactory(this, appState!!)
    }
    private var appState: MainViewModel? = null
    override fun onCreate() {
        super.onCreate()
        appState = MainViewModel(appRepository = AppRepository())

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