package com.example.tococd.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tococd.domain.repository.DataStoreOperations
import com.example.tococd.utils.Constants.PREFERENCES_NAME
import com.example.tococd.utils.Constants.SHARED_INFORMATION
import com.example.tococd.utils.Constants.SHARED_NAME
import com.example.tococd.utils.Constants.SHARED_PSYCHOLOGISTS
import com.example.tococd.utils.Constants.SHARED_TYPES
import com.example.tococd.utils.extension.handleException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl @Inject constructor(context: Context) : DataStoreOperations {

    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val name = stringPreferencesKey(SHARED_NAME)
        val information = stringPreferencesKey(SHARED_INFORMATION)
        val types = stringPreferencesKey(SHARED_TYPES)
        val psychologist = stringPreferencesKey(SHARED_PSYCHOLOGISTS)
    }

    override suspend fun saveName(name: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.name] = name
        }
    }

    override fun getName(): Flow<String> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.name] ?: ""
            }
    }

    override suspend fun saveInformation(name: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.information] = name
        }
    }

    override fun getInformation(): Flow<String> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.information] ?: ""
            }
    }

    override suspend fun saveTypes(name: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.types] = name
        }
    }

    override fun getTypes(): Flow<String> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.types] ?: ""
            }
    }

    override suspend fun savePsychologist(name: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.psychologist] = name
        }
    }

    override fun getPsychologist(): Flow<String> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.psychologist] ?: ""
            }
    }
}