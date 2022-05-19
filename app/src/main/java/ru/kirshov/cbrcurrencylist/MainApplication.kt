package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kirshov.cbrcurrencylist.di.Dependencies
import ru.kirshov.cbrcurrencylist.domain.ApplicationViewModelFactory
import ru.kirshov.cbrcurrencylist.domain.story.AppStory

class MainApplication:Application(){
    private var dependencies:Dependencies? = null
    private val story:AppStory by lazy(LazyThreadSafetyMode.NONE) { AppStory() }
    override fun onCreate() {
        super.onCreate()
        dependencies = Dependencies(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        dependencies = null
    }

    fun viewModelFactory():ApplicationViewModelFactory{
            return ApplicationViewModelFactory()
    }
}

val Context.factory:ApplicationViewModelFactory get(){
    return (this.applicationContext as MainApplication).viewModelFactory()
}