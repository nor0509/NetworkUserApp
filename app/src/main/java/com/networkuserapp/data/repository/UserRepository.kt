package com.networkuserapp.data.repository

import com.networkuserapp.data.api.ApiService
import com.networkuserapp.data.local.dao.UserDao
import com.networkuserapp.data.local.entity.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun getUsers(): List<UserEntity> {
        return try {
            val userResponses = apiService.getUsers()

            val userEntities = userResponses.map { it.toUserEntity() }

            userDao.upsertUsers(userEntities)

            userEntities
        } catch (e: Exception) {
            userDao.getUsers()
        }
    }
}
