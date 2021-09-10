package com.kouta.customtwitter.ui.login

import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class LoginViewModelTest{
    private lateinit var loginViewModelSpy: LoginViewModel

    @MockK(relaxed = true)
    lateinit var userSettingRepository: UserSettingRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        loginViewModelSpy = spyk(LoginViewModel(userSettingRepository), recordPrivateCalls = true)
    }

    @Test
    fun putData_failed() {
        val fakeStringData = DataType.StringData("fake_key", "fake_default", "fake_default_value")

        every { userSettingRepository.putData(any()) }

        loginViewModelSpy.putData(listOf(fakeStringData))

        verify(exactly = 1) {
            userSettingRepository.putData(listOf(fakeStringData))
        }
    }
}