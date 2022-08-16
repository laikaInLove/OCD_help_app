package com.example.tococd.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveName(name: String)
    fun getName(): Flow<String>

    suspend fun saveInformation(name: String)
    fun getInformation(): Flow<String>

    suspend fun saveTypes(displayed: Boolean)
    fun getTypes(): Flow<Boolean>

    suspend fun savePsychologist(displayed: Boolean)
    fun getPsychologist(): Flow<Boolean>

    suspend fun setOnboardingDisplayed(isDisplayed: Boolean)
    fun getOnboardingDisplayed(): Flow<Boolean>
}