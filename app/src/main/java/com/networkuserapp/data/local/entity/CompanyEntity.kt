package com.networkuserapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class CompanyEntity (
    val name: String,
    val catchPhrase: String,
    val bs: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
){
}