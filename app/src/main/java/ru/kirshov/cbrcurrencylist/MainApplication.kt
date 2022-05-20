package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kirshov.cbrcurrencylist.di.Dependencies
import ru.kirshov.cbrcurrencylist.domain.ApplicationViewModelFactory
import ru.kirshov.cbrcurrencylist.domain.story.AppStory

class MainApplication:Application(){

    val viewModelFactory by lazy { ApplicationViewModelFactory(this) }
}

val Context.factory:ApplicationViewModelFactory get(){
    return (this.applicationContext as MainApplication).viewModelFactory
}