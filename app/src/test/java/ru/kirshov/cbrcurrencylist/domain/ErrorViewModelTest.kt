@file:OptIn(ExperimentalCoroutinesApi::class)

package ru.kirshov.cbrcurrencylist.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


class ErrorViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    @Before
    fun before(){
        Dispatchers.setMain(dispatcher)
    }
    @After
    fun after(){
        Dispatchers.resetMain()
    }
    @Test
    fun notNullTest() = runTest {

    }
}





