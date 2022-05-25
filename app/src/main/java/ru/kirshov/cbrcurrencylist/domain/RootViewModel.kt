package ru.kirshov.cbrcurrencylist.domain

import androidx.lifecycle.ViewModel
import ru.kirshov.cbrcurrencylist.domain.story.AppRepository

class RootViewModel(
    private val repository: DataStore
):ViewModel() {
}