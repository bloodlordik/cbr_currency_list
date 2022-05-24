package ru.kirshov.cbrcurrencylist.domain.story

data class AppState(
    val appInfo: AppDataInfo,
    val currencyList: List<CurrencyItem>,
    val error: AppError,
    val status:AppEvents
) {
    companion object {
        fun createEmpty(): AppState = AppState(
            appInfo = AppDataInfo.createEmpty(),
            currencyList = emptyList(),
            error = AppError.createEmpty(),
            status = Loading
        )
    }
}





