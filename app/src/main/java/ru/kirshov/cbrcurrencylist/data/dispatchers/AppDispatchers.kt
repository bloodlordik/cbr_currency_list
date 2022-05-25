package ru.kirshov.cbrcurrencylist.data.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}

fun AppDispatchers(io:CoroutineDispatcher,main:CoroutineDispatcher):AppDispatchers{
    return object :AppDispatchers{
        override val io: CoroutineDispatcher
            get() = io
        override val main: CoroutineDispatcher
            get() = main

    }
}