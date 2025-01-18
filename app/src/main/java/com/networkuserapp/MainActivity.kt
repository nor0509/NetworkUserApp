package com.networkuserapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.networkuserapp.ui.screens.MainScreen
import com.networkuserapp.ui.theme.NetworkUserAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkUserAppTheme {
                MainScreen()

            }
        }
    }
}


