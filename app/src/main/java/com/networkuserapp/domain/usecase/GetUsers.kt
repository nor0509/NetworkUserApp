package com.networkuserapp.domain.usecase

import android.util.Log
import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.data.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun execute(): List<UserEntity> {
        return try {
            userRepository.getUsersFromApi()
        } catch (e: Exception) {
            Log.e("GetUsersUseCase", "Error fetching users from API: ${e.localizedMessage}", e)
            emptyList()
        }
    }

    suspend fun getUsersFromLocal(): List<UserEntity> {
        return try {
            userRepository.getUsersFromLocal()
        } catch (e: Exception) {
            Log.e("GetUsersUseCase", "Error fetching users from local database: ${e.localizedMessage}", e)
            emptyList()
        }
    }
}
