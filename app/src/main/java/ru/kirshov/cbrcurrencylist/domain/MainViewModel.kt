package ru.kirshov.cbrcurrencylist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.kirshov.cbrcurrencylist.data.dispatchers.AppDispatchers
import ru.kirshov.cbrcurrencylist.domain.story.AppError
import ru.kirshov.cbrcurrencylist.domain.story.AppEvents
import ru.kirshov.cbrcurrencylist.domain.story.AppRepository

class MainViewModel(
    private val appRepository: AppRepository,
    private val dispatchers: AppDispatchers
):ViewModel() {
    fun update(){
        viewModelScope.launch {
            appRepository.update(dispatcher = dispatchers.io)
        }
    }
    val status:LiveData<AppEvents> = appRepository.status.asLiveData(context = dispatchers.main)

}