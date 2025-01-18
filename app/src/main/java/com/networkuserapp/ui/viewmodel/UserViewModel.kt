package com.networkuserapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun upsertUser(user: UserEntity) = viewModelScope.launch {
        userRepository.upsertUser(user)
    }

    fun deleteUser(user: UserEntity) = viewModelScope.launch {
        userRepository.deleteUser(user)
    }

    suspend fun getAllUsers(): Flow<List<UserEntity>> {
        return userRepository.getUserOrderedByLastName()
    }

    suspend fun getUserById(id: Int): UserEntity? {
        return userRepository.getUserById(id)
    }

    suspend fun getUserOrderedByFirstName(name: String): UserEntity? {
        return userRepository.getUserOrderedByFirstName(name)
    }
}