package com.networkuserapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.networkuserapp.data.local.entity.AddressEntity

@Dao
interface AddressDao {

    @Upsert
    suspend fun insertAddress(company: AddressEntity)

    @Delete
    suspend fun deleteAddress(company: AddressEntity)
}
