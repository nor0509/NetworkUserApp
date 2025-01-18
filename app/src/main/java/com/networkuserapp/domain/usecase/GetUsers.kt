package com.networkuserapp.domain.usecase

import com.networkuserapp.data.local.entity.UserEntity
import com.networkuserapp.data.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute(): List<UserEntity> {
        return userRepository.getUsers()
    }
}
