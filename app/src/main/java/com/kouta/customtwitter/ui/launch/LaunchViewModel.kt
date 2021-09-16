package com.kouta.customtwitter.ui.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouta.customtwitter.model.Result
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import com.kouta.customtwitter.utils.Params.SharedPreferencesKey.ACCESS_TOKEN
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
            val data = getData(
                DataType.StringData(
                    key = ACCESS_TOKEN,
                    value = DEFAULT_VALUE,
                    defaultValue = DEFAULT_VALUE
                )
            )

            if ((data as DataType.StringData).value == data.defaultValue) _launchState.value = LaunchState.Complete(false)
            else _launchState.value = LaunchState.Complete(true)
        }
    }

    private fun getData(
        dataType: DataType
    ): DataType {
        return when(val result: Result<DataType> = userSettingRepository.getData(dataType)) {
            is Result.Success -> {
                result.data
            }
            is Result.Error -> {
                /*TODO: エラー時の処理を追加*/
                DataType.StringData(
                    "error_key",
                    "error_value",
                    "error_default_value"
                )
            }
        }
    }
}