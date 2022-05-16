package ru.kirshov.cbrcurrencylist

import android.app.Application
import android.content.Context
import ru.kirshov.cbrcurrencylist.di.Dependensies

class MainApplication:Application(){
    private var dependencies:Dependensies? = null
    override fun onCreate() {
        super.onCreate()
        dependencies = Dependensies(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        dependencies = null
    }
    fun getDependencies(): Dependensies {
        return checkNotNull(dependencies)
    }
}

val Context.dependencies:Dependensies get(){
    return (this.applicationContext as MainApplication).getDependencies()
}