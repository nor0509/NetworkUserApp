package com.networkuserapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.networkuserapp.data.local.entity.CompanyEntity
import com.networkuserapp.data.repository.CompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val companyRepository: CompanyRepository
) : ViewModel() {

    fun upsertCompany(company: CompanyEntity) = viewModelScope.launch {
        companyRepository.upsertCompany(company)
    }

    fun deleteCompany(company: CompanyEntity) = viewModelScope.launch {
        companyRepository.deleteCompany(company)
    }
}