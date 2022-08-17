package com.example.tococd.domain.repository

import com.example.tococd.domain.common.Result
import com.example.tococd.domain.model.Psychologist

interface PsychologistRepository {
    suspend fun getPsychologists(): Result<List<Psychologist>>
}