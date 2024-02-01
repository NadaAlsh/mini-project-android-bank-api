package com.joincoded.bankapi.viewmodel

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.BankApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val Application.dataStore: DataStore<Preferences>
    get() {
        TODO("Not yet implemented")
    }

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val apiService = RetrofitHelper.getInstance().create(BankApiService::class.java)
    private val dataStore: DataStore<Preferences> = application.dataStore

    val token: Flow<String?> = dataStore.data
        .catch { exception ->
            if (exception is Exception) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[PreferencesKeys.TOKEN] ?: ""
        }

    fun signUp(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, image, null,0.0))
                val newToken = response.body()?.token ?: ""
                saveToken(newToken)
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    private suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.TOKEN] = token
        }
    }

    private object PreferencesKeys {
        val TOKEN = stringPreferencesKey("token")
    }
}