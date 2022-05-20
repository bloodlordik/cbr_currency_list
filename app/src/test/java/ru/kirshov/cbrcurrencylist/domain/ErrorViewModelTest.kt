package ru.kirshov.cbrcurrencylist.domain

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import ru.kirshov.cbrcurrencylist.domain.story.AppError
import ru.kirshov.cbrcurrencylist.domain.story.AppErrors
import ru.kirshov.cbrcurrencylist.domain.story.StoryController


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

        val dep = ControllerTest()
        val viewModel = ErrorViewModel(dep,dep)
        val one = viewModel.errorTitle.value
        assertThat(one).isNotNull()
    }
}

private class ControllerTest() : AppErrors<AppError>, StoryController {
    private val errors = MutableStateFlow(initError)
    override val error: Flow<AppError> = errors.map { AppError(it) }
    override fun update() {

    }


}

private const val initError = "Init Error"
private const val secondError = "Second error"




