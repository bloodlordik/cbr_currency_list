package ru.kirshov.cbrcurrencylist.domain.story

interface State<T>{
    val value:T
}

interface MutableState<T>:State<T>{
    override var value:T
}
