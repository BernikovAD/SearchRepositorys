package com.abernikov.domain

import com.abernikov.domain.utils.RequestStatus
import com.abernikov.model.ResponseSearchRepositories

interface SearchRepositories {
    suspend fun getRepositories(
        q: String,
        perPage: Int,
        page: Int
    ): RequestStatus<ResponseSearchRepositories>
}