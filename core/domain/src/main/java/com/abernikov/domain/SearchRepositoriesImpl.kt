package com.abernikov.domain

import com.abernikov.domain.utils.ApiUtils
import com.abernikov.domain.utils.RequestStatus
import com.abernikov.model.ResponseSearchRepositories
import javax.inject.Inject

class SearchRepositoriesImpl @Inject constructor(private val apiService: ApiService) :
    SearchRepositories {
    override suspend fun getRepositories(
        q: String,
        perPage: Int,
        page: Int
    ): RequestStatus<ResponseSearchRepositories> = ApiUtils.apiCall(request = {
        apiService.getRepositories(
            q = q,
            per_page = perPage,
            page = page
        )
    })
    /*    fun getRepositories(q: String): LiveData<PagingData<Items>> {
            return Pager(
                config = PagingConfig(
                    pageSize = 20,
                    enablePlaceholders = false,
                    initialLoadSize = 2
                ),
                pagingSourceFactory = {
                    RepositoriesPagingSource(apiService = apiService, query = q)
                }, initialKey = 1
            ).liveData
        }*/
}