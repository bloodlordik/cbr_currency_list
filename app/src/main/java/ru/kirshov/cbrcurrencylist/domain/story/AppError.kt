package ru.kirshov.cbrcurrencylist.domain.story

data class AppError(
    val error:String
){
    companion object {
        fun createEmpty():AppError{
            return AppError(error = "")
        }
    }
}
