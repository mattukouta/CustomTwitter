package com.kouta.customtwitter.ui.launch

import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class LaunchViewModelTest {
    private lateinit var launchViewModelSpy: LaunchViewModel

    @MockK(relaxed = true)
    lateinit var userSettingRepository: UserSettingRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        launchViewModelSpy = spyk(LaunchViewModel(userSettingRepository), recordPrivateCalls = true)
    }

    @Test
    fun getUserData_return_complete_true() = runBlocking {
        val fakeStringData = DataType.StringData("fake_key", "fake_default", "fake_default_value")

        every { userSettingRepository.getData(any()) } returns fakeStringData

        launchViewModelSpy.getUserData()

        verify(exactly = 1) {
            userSettingRepository.getData(any())
        }

        assertEquals(launchViewModelSpy.launchState.value, LaunchState.Complete(true))
    }

    @Test
    fun getUserData_return_complete_false() = runBlocking {
        val fakeStringData = DataType.StringData("fake_key", "fake_default_value", "fake_default_value")

        every { userSettingRepository.getData(any()) } returns fakeStringData

        launchViewModelSpy.getUserData()

        verify(exactly = 1) {
            userSettingRepository.getData(any())
        }

        assertEquals(launchViewModelSpy.launchState.value, LaunchState.Complete(false))
    }
}