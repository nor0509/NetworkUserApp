package com.networkuserapp.domain.usecase

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import javax.inject.Inject

class NetworkUtils @Inject constructor(
    private val context: Context
) {

    fun isInternetAvailable(): Boolean {
        return try {
            isNetworkConnected()
        } catch (e: Exception) {
            Log.e("NetworkUtils", "Error checking network connectivity", e)
            false
        }
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            ?: throw Exception("ConnectivityManager not available")

        val network = connectivityManager.activeNetwork ?: throw Exception("No active network found")
        val capabilities = connectivityManager.getNetworkCapabilities(network)
            ?: throw Exception("No network capabilities found")

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}











