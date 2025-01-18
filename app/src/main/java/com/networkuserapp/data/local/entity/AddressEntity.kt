package com.networkuserapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded val geo: GeoEntity,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
}
class GeoEntity (
    val lat: String,
    val lng: String
) {
}
