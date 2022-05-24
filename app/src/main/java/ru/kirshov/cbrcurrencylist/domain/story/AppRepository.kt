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

class AppRepository(
    private val cbrRepository: CbrRepository = CbrRepositoryClient().getRepository(),
    appState: AppState = AppState.createEmpty()
) {
    private val _status = MutableStateFlow(appState.status)
    private val _errors = MutableStateFlow(appState.error)

    suspend fun update(dispatcher: CoroutineDispatcher = Dispatchers.IO) = withContext(dispatcher) {
        try {
            val result = cbrRepository.getCurrencyList()
            if (result.currencyList.isNotEmpty()) {
                _status.update { Done }
            }

        } catch (io: IOException) {
            _errors.update { AppError("Lpgg") }
            _status.update { Error }
        }
    }
    val status:StateFlow<AppEvents> = _status
}