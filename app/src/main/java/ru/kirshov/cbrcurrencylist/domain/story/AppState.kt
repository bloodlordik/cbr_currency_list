package ru.kirshov.cbrcurrencylist.domain.story

data class AppState(
    val appInfo:AppDataInfo,
    val currencyList: List<CurrencyItem>,
    val error:AppError?,
    val status: STATUS
){
    enum class STATUS{
        EMPTY, NEW, OLD
    }
    companion object {
        fun createEmpty():AppState = AppState(
            appInfo = AppDataInfo.createEmpty(),
            currencyList = emptyList(),
            error = null,
            status = STATUS.EMPTY
        )
    }
}





