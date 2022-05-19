package ru.kirshov.cbrcurrencylist.domain

import androidx.lifecycle.ViewModel
import ru.kirshov.cbrcurrencylist.domain.story.AppEventListener
import ru.kirshov.cbrcurrencylist.domain.story.AppEvents

class MainViewModel(
    private val events:AppEventListener<AppEvents>
):ViewModel() {

}