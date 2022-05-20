package ru.kirshov.cbrcurrencylist.presentations.binding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewBindingDelegate<T:ViewBinding>(private val binder:(View)->T):ReadOnlyProperty<Fragment,T> {
    private var _binding:T? = null
    private val observer = Observer()
    private val errorMessage ="view binding is null!!"
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        thisRef.lifecycle.addObserver(observer)
        val view = thisRef.requireView()
        _binding = binder.invoke(view)
        return checkNotNull(_binding){
            errorMessage
        }
    }
    private inner class Observer:DefaultLifecycleObserver{
        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            owner.lifecycle.removeObserver(observer)
            _binding = null

        }
    }
}