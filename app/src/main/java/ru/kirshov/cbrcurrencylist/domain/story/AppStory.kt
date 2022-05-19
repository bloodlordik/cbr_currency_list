package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

class AppStory {
    private val state = MutableStateFlow<AppState>(AppState.createEmpty())

    fun loadState(scope: CoroutineScope){

    }
}