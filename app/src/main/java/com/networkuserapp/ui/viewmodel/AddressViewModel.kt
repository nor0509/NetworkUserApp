package com.networkuserapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.networkuserapp.data.local.entity.AddressEntity
import com.networkuserapp.data.repository.AddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    private val addressRepository: AddressRepository
) : ViewModel() {

    fun upsertAddress(address: AddressEntity) = viewModelScope.launch {
        addressRepository.upsertAddress(address)
    }

    fun deleteAddress(address: AddressEntity) = viewModelScope.launch {
        addressRepository.deleteAddress(address)
    }
}