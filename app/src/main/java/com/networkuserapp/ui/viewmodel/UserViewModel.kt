package com.networkuserapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.domain.usecase.GetUsersUseCase
import com.networkuserapp.domain.usecase.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _users = MutableLiveData<List<UserEntity>>(emptyList())
    val users: LiveData<List<UserEntity>> = _users

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun fetchUsers() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                if (networkUtils.isInternetAvailable()) {
                    val userList = getUsersUseCase.execute()
                    _users.postValue(userList)
                } else {
                    val userList = getUsersUseCase.getUsersFromLocal()
                    _users.postValue(userList)
                    _errorMessage.postValue("No internet connection. Showing local data.")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Error occurred while fetching users: ${e.message}")
                _users.postValue(emptyList())
            } finally {
                _isLoading.value = false
            }
        }
    }
}
