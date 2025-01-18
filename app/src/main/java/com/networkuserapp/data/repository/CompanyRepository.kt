package com.networkuserapp.data.repository

import com.networkuserapp.data.local.dao.CompanyDao
import com.networkuserapp.data.local.entity.CompanyEntity
import javax.inject.Inject

class CompanyRepository @Inject constructor(
    private val companyDao: CompanyDao
) {

    suspend fun upsertCompany(company: CompanyEntity) {
        companyDao.insertCompany(company)
    }

    suspend fun deleteCompany(company: CompanyEntity) {
        companyDao.deleteCompany(company)
    }
}