package com.abernikov.mainscreen

import androidx.lifecycle.viewModelScope
import com.abernikov.common.BaseViewModel
import com.abernikov.domain.SearchRepositoriesImpl
import com.abernikov.domain.utils.RequestStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val repository: SearchRepositoriesImpl) :
    BaseViewModel<MainScreenState>(MainScreenState.Loading) {
    var query = ""

    fun getRepositories() {
        state.value = MainScreenState.Loading
        viewModelScope.launch(Dispatchers.IO) {

            when (val response = repository.getRepositories(query, 10, 1)) {
                is RequestStatus.Error -> state.postValue(response.message?.let {
                    MainScreenState.Error(
                        it
                    )
                })

                is RequestStatus.Success -> {
                    state.postValue(MainScreenState.Success(response.data?.items))
                }
            }
        }
    }
}