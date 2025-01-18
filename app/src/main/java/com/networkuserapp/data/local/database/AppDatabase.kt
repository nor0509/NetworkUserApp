package com.networkuserapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.networkuserapp.data.local.dao.UserDao
import com.networkuserapp.data.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
