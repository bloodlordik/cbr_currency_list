package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import ru.kirshov.cbrcurrencylist.di.Dependencies

class MainApplication:Application(){
    private var dependencies:Dependencies? = null
    override fun onCreate() {
        super.onCreate()
        dependencies = Dependencies(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        dependencies = null
    }
    fun getDependencies(): Dependencies {
        return checkNotNull(dependencies)
    }
}

val Context.dependencies:Dependencies get(){
    return (this.applicationContext as MainApplication).getDependencies()
}