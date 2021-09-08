package com.kouta.customtwitter.ui.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import com.kouta.customtwitter.utils.Params.Key.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val userSettingRepository: UserSettingRepository
): ViewModel() {
    private val _launchState: MutableStateFlow<LaunchState> = MutableStateFlow(LaunchState.Loading)
    val launchState: StateFlow<LaunchState> get() = _launchState

    private val DEFAULT_VALUE = ""

    fun getUserData() {
        viewModelScope.launch(Default) {
            val data = userSettingRepository.getData(
                DataType.StringData(
                    key = ACCESS_TOKEN,
                    value = DEFAULT_VALUE
                )
            )

            if ((data as DataType.StringData).value == DEFAULT_VALUE) _launchState.value = LaunchState.Complete(false)
            else _launchState.value = LaunchState.Complete(true)
        }
    }
}