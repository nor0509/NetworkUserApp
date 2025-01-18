package com.networkuserapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.networkuserapp.data.local.dao.AddressDao
import com.networkuserapp.data.local.dao.CompanyDao
import com.networkuserapp.data.local.dao.UserDao
import com.networkuserapp.data.local.entity.AddressEntity
import com.networkuserapp.data.local.entity.CompanyEntity
import com.networkuserapp.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        AddressEntity::class,
        CompanyEntity::class
    ],
    version = 1
)


abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun addressDao(): AddressDao
    abstract fun companyDao(): CompanyDao
}