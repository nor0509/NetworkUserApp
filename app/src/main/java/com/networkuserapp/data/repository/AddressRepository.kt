package com.networkuserapp.data.repository

import com.networkuserapp.data.local.dao.AddressDao
import com.networkuserapp.data.local.entity.AddressEntity
import javax.inject.Inject

class AddressRepository @Inject constructor(
    private val addressDao: AddressDao
) {

    suspend fun upsertAddress(address: AddressEntity) {
        addressDao.insertAddress(address)
    }

    suspend fun deleteAddress(address: AddressEntity) {
        addressDao.deleteAddress(address)
    }
}