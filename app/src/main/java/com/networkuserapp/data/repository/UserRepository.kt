package com.networkuserapp.data.repository

import com.networkuserapp.data.local.dao.UserDao
import com.networkuserapp.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun upsertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }

    suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    suspend fun getUserById(id: Int): UserEntity? {
        return userDao.getUserById(id)
    }

    suspend fun getUserOrderedByFirstName(name: String): UserEntity? {
        return userDao.getUserOrderedByFirstName(name)
    }

    suspend fun getUserOrderedByLastName(): Flow<List<UserEntity>> {
        return userDao.getUserOrderedByLastName()
    }
}