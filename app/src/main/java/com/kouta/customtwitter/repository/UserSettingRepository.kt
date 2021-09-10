package com.kouta.customtwitter.repository

import javax.inject.Inject
import android.content.SharedPreferences
import kotlin.Exception
import com.kouta.customtwitter.model.Result

class UserSettingRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun putData(dataTypes: List<DataType>): Result<Any> {
        try {
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

            return Result.Success(Any())
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

    fun getData(dataType: DataType): Result<DataType> {
        try {
            sharedPreferences.apply {
                when(dataType) {
                    is DataType.IntData -> {
                        val value = getInt(dataType.key, dataType.defaultValue)

                        return Result.Success(
                            DataType.IntData(
                                dataType.key,
                                value,
                                dataType.defaultValue
                            )
                        )
                    }

                    is DataType.StringData -> {
                        val value = getString(dataType.key, dataType.defaultValue)

                        return Result.Success(
                            DataType.StringData(
                                dataType.key,
                                value ?: dataType.defaultValue,
                                dataType.defaultValue
                            )
                        )
                    }
                }
            }
        } catch (e: Exception) {
            return Result.Error(e)
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