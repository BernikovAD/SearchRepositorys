package com.abernikov.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.abernikov.model.Items
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException

class RepositoriesPagingSource @AssistedInject constructor(
    private val apiService: ApiService,
    @Assisted("query") private val query: String
) : PagingSource<Int, Items>() {
    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        if (query.isBlank()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }

        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val pageSize = params.loadSize.coerceAtMost(20)
            val response = apiService.getRepositories(query, pageSize, pageNumber)

            return if (response.isSuccessful) {
                val articles = response.body()!!.items
                val nextPageNumber = if (articles.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(articles, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}