package com.maxwell.nlpcpod.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.maxwell.nlpcpod.domain.manager.TokenManager
import com.maxwell.nlpcpod.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constant.SETTINGS)

private object PreferencesKeys {
    val ACCESS_TOKEN = stringPreferencesKey(name = Constant.ACCESS_TOKEN)
}

class ManagerImpl(private val context:Context) : TokenManager {

    override fun getAccessToken(): Flow<String> {
        return context.dataStore.data.map {
            preferences->
            preferences[PreferencesKeys.ACCESS_TOKEN]?:""
        }
    }

    override suspend fun saveAccessToke(token: String) {
        context.dataStore.edit { settings -> settings[PreferencesKeys.ACCESS_TOKEN] = token }
    }
}