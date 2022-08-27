package com.example.tococd.data.remote.service

import com.example.tococd.data.remote.response.PsychologistsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale

interface APIService {
    @GET("psychologists")
    suspend fun getPsychologists(
        @Query("lang") lang: String = Locale.getDefault().language
    ): Response<List<PsychologistsResponse>>
}