package com.example.tococd.domain.repository

interface PsychologistRepository {
    suspend fun getPsychologists()
}