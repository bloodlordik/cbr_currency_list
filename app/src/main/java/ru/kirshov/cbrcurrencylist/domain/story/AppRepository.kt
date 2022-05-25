package ru.kirshov.cbrcurrencylist.domain.story

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import okio.IOException
import ru.kirshov.cbrcurrencylist.data.repository.CbrRepository
import ru.kirshov.cbrcurrencylist.data.repository.CbrRepositoryClient
import ru.kirshov.cbrcurrencylist.domain.DataStore
import ru.kirshov.cbrcurrencylist.domain.ErrorStore
import ru.kirshov.cbrcurrencylist.domain.binders.toInfo
import ru.kirshov.cbrcurrencylist.domain.binders.toList

class AppRepository(
    private val cbrRepository: CbrRepository = CbrRepositoryClient().getRepository(),
    appState: AppState = AppState.createEmpty()
):DataStore, ErrorStore {
    private val _status = MutableStateFlow(appState.status)
    private val _errors = MutableStateFlow(appState.error)
    private val _data = MutableStateFlow(appState.currencyList)
    private val _info = MutableStateFlow(appState.appInfo)

    override suspend fun update(dispatcher: CoroutineDispatcher):Unit = withContext(dispatcher) {
        try {
            val result = cbrRepository.getCurrencyList()

            if (result.currencyList.isNotEmpty()) {
                _status.update { Done }
                _data.update { result.toList() }
                _info.update { result.toInfo() }
            }

        } catch (io: IOException) {
            _errors.update { AppError("Lpgg") }
            _status.update { Error }
        }
    }
    val status:StateFlow<AppEvents> = _status
    override val errors:StateFlow<AppError> = _errors
    override val data:StateFlow<List<CurrencyItem>> = _data
    override val info:StateFlow<AppDataInfo> = _info

}