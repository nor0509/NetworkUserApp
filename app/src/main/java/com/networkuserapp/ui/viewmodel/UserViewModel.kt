package com.networkuserapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val users = MutableLiveData<List<UserEntity>>()

    fun fetchUsers() {
        viewModelScope.launch {
            val userList = getUsersUseCase.execute()
            users.postValue(userList)
        }
    }
}
