package com.networkuserapp.data.api.response

import com.networkuserapp.data.local.entity.UserEntity

data class UserResponse(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressResponse,
    val phone: String,
    val website: String,
    val company: CompanyResponse
) {
    fun toUserEntity(): UserEntity {
        return UserEntity(
            id = this.id,
            name = this.name,
            username = this.username,
            email = this.email,
            street = this.address.street,
            suite = this.address.suite,
            city = this.address.city,
            zipcode = this.address.zipcode,
            geoLat = this.address.geo.lat,
            geoLng = this.address.geo.lng,
            phone = this.phone,
            website = this.website,
            companyName = this.company.name,
            companyCatchPhrase = this.company.catchPhrase,
            companyBs = this.company.bs
        )
    }
}

data class CompanyResponse(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class AddressResponse(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoResponse
)

data class GeoResponse(
    val lat: String,
    val lng: String
)
