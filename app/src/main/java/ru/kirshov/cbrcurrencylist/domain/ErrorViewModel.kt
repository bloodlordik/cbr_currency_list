package ru.kirshov.cbrcurrencylist.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.kirshov.cbrcurrencylist.domain.story.AppError
import ru.kirshov.cbrcurrencylist.domain.story.AppErrors
import ru.kirshov.cbrcurrencylist.domain.story.StoryController
import ru.kirshov.cbrcurrencylist.presentations.vewstates.ErrorViewState
import ru.kirshov.cbrcurrencylist.presentations.vewstates.Loading
import ru.kirshov.cbrcurrencylist.presentations.vewstates.ShowError

class ErrorViewModel(
    private val error: AppErrors<AppError>,
    private val storyController: StoryController,
) : ViewModel() {

    init {
        viewModelScope.launch {
            error.error.collect {
                errorChanel.send(element = ShowError(it.error))
            }
        }
    }

    private val errorChanel = Channel<ErrorViewState>()

    val errorTitle = errorChanel.receiveAsFlow().asLiveData()
    fun update() {
        viewModelScope.launch {
            errorChanel.send(Loading)
            storyController.update()
        }
    }

    override fun onCleared() {
        super.onCleared()
        errorChanel.close()
    }
}