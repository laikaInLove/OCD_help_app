package com.example.tococd.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPsychologists(@Url url: String): Response<List<PsychologistsResponse>>
}