package com.example.tococd.data.repository

import com.example.tococd.data.remote.service.APIService
import com.example.tococd.domain.common.Result
import com.example.tococd.domain.common.fold
import com.example.tococd.domain.common.makeSafeRequest
import com.example.tococd.domain.model.Psychologist
import com.example.tococd.domain.repository.PsychologistRepository
import javax.inject.Inject

class PsychologistRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : PsychologistRepository {

    override suspend fun getPsychologists(): Result<List<Psychologist>> {
        val response = makeSafeRequest {
            apiService.getPsychologists()
        }

        return response.fold(
            onSuccess = {
                Result.Success(it.map { psychologistItem -> psychologistItem.toDomain() })
            },
            onError = { code, message ->
                Result.Error(code, message)
            },
            onException = {
                Result.Exception(it)
            }
        )
    }
}