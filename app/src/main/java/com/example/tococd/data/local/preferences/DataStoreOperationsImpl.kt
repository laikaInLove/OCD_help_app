package com.example.tococd.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tococd.domain.repository.DataStoreOperations
import com.example.tococd.utils.Constants.ONBOARDING_DISPLAYED
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
        val information = booleanPreferencesKey(SHARED_INFORMATION)
        val types = booleanPreferencesKey(SHARED_TYPES)
        val psychologist = booleanPreferencesKey(SHARED_PSYCHOLOGISTS)
        val onboarding = booleanPreferencesKey(ONBOARDING_DISPLAYED)

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

    override suspend fun saveInformation(displayed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.information] = displayed
        }
    }

    override fun getInformation(): Flow<Boolean> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.information] ?: false
            }
    }

    override suspend fun saveTypes(displayed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.types] = displayed
        }
    }

    override fun getTypes(): Flow<Boolean> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.types] ?: false
            }
    }

    override suspend fun savePsychologist(displayed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.psychologist] = displayed
        }
    }

    override fun getPsychologist(): Flow<Boolean> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.psychologist] ?: false
            }
    }

    override suspend fun setOnboardingDisplayed(isDisplayed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.onboarding] = isDisplayed
        }
    }

    override fun getOnboardingDisplayed(): Flow<Boolean> {
        return dataStore.data.handleException()
            .map { preferences ->
                preferences[PreferencesKeys.onboarding] ?: false
            }
    }
}