package com.networkuserapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.networkuserapp.data.local.entity.CompanyEntity

@Dao
interface CompanyDao {

    @Upsert
    suspend fun insertCompany(company: CompanyEntity)

    @Delete
    suspend fun deleteCompany(company: CompanyEntity)
}