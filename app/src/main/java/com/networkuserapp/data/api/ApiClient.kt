package com.networkuserapp.data.api

import retrofit2.http.GET

interface ApiClient {
    @GET("test")
    suspend fun doNetworkCall()
}