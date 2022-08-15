package com.example.tococd.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveName(name: String)
    fun getName(): Flow<String>

    suspend fun saveInformation(name: String)
    fun getInformation(): Flow<String>

    suspend fun saveTypes(name: String)
    fun getTypes(): Flow<String>

    suspend fun savePsychologist(name: String)
    fun getPsychologist(): Flow<String>
}