package com.example.tococd.data.remote.service

import com.example.tococd.data.remote.response.PsychologistsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPsychologists(@Url url: String): Response<List<PsychologistsResponse>>
}