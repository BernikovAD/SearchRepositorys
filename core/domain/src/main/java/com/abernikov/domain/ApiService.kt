package com.abernikov.domain

import androidx.annotation.IntRange
import com.abernikov.model.ResponseSearchRepositories
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/search/repositories")
    suspend fun getRepositories(
        @Query("q") q: String,
        @Query("per_page") @IntRange(
            from = 1,
            to = MAX_PAGE_SIZE.toLong()
        ) per_page: Int = DEFAULT_PAGE_SIZE,
        @Query("page") @IntRange(from = 1) page: Int
    ): Response<ResponseSearchRepositories>

    companion object {
        const val DEFAULT_PAGE_SIZE = 20
        const val MAX_PAGE_SIZE = 20
    }
}