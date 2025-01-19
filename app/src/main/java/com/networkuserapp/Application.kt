//APP MADE BY
//NORBERT KABZIŃSKI
//ŁUKASZ SERWATKA
//KSAWERY KOSARSKI
//MIKOŁAJ ĆMOK

package com.networkuserapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NetworkUserAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
