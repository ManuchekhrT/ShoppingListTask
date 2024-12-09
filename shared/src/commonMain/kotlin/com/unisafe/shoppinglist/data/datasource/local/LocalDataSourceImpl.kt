package com.unisafe.shoppinglist.data.datasource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

private const val KEY_NAME = "key"

class LocalDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : LocalDataSource {

    companion object {
        val KEY = stringPreferencesKey(KEY_NAME)
    }

    override suspend fun saveKey(key: String) {
        dataStore.edit { prefs ->
            prefs[KEY] = key
        }
    }

    override suspend fun getKey(): String {
        val prefs = dataStore.data.first()
        return prefs[KEY] ?: ""
    }
}