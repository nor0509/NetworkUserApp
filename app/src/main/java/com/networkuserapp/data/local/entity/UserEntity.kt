package com.networkuserapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = AddressEntity::class,
            parentColumns = ["id"],
            childColumns = ["addressID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CompanyEntity::class,
            parentColumns = ["id"],
            childColumns = ["companyID"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["addressID"]),
        Index(value = ["companyID"])
    ]
)
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val addressID: Int,
    val phone: String,
    val website: String,
    val companyID: Int,
    val profilePicture: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0
)