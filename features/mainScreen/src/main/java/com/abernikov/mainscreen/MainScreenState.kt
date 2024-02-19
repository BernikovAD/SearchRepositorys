package com.abernikov.mainscreen

import com.abernikov.common.IViewModelState
import com.abernikov.model.Items
import com.abernikov.model.ResponseSearchRepositories

sealed class MainScreenState : IViewModelState {
    data object Loading : MainScreenState()
    data class Success(val repositories: List<Items>?) : MainScreenState()
    data class Error(val message: String) : MainScreenState()
}

sealed class Resource {
    val data: ResponseSearchRepositories = ResponseSearchRepositories(30, arrayListOf())

    class Failure : Resource()
    class Loading : Resource()
    class Success : Resource()
}