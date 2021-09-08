package com.kouta.customtwitter.repository

import javax.inject.Inject
import android.content.SharedPreferences

class UserSettingRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun putData(dataTypes: List<DataType>) {
        sharedPreferences
            .edit()
            .apply {
                dataTypes.forEach { dataType ->
                    when(dataType) {
                        is DataType.IntData -> putInt(dataType.key, dataType.value)
                        is DataType.StringData -> putString(dataType.key, dataType.value)
                    }
                }
                apply()
            }
    }

    fun getData(dataType: DataType): DataType {
        sharedPreferences.apply {
            when(dataType) {
                is DataType.IntData -> {
                    val value = getInt(dataType.key, dataType.defaultValue)

                    return DataType.IntData(
                        dataType.key,
                        value,
                        dataType.defaultValue
                    )
                }

                is DataType.StringData -> {
                    val value = getString(dataType.key, dataType.defaultValue)

                    return DataType.StringData(
                        dataType.key,
                        value ?: dataType.defaultValue,
                        dataType.defaultValue
                    )
                }
            }
        }
    }
}

sealed class DataType {
    data class IntData(
        val key: String,
        val value: Int = 0,
        val defaultValue: Int = 0
    ): DataType()

    data class StringData(
        val key: String,
        val value: String = "",
        val defaultValue: String = ""
    ): DataType()
}