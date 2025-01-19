package com.networkuserapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.networkuserapp.domain.usecase.NetworkUtils
import com.networkuserapp.ui.components.BottomBar
import com.networkuserapp.ui.components.UserList
import com.networkuserapp.ui.theme.ErrorColor
import com.networkuserapp.ui.viewmodel.UserViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val userViewModel: UserViewModel = hiltViewModel()

    val isLoading by userViewModel.isLoading.observeAsState(false)
    val users by userViewModel.users.observeAsState(emptyList())
    val errorMessage by userViewModel.errorMessage.observeAsState()

    val networkUtils = NetworkUtils(LocalContext.current)
    var isNetworkAvailable by remember { mutableStateOf(networkUtils.isInternetAvailable()) }

    LaunchedEffect(Unit) {
            val internetStatus = networkUtils.isInternetAvailable()
            isNetworkAvailable = internetStatus
            delay(5000)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "NetworkUserApp",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                },
                actions = {
                    IconButton(onClick = { /*todo*/ }) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Profile",

                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                onHomeClick = { /*todo*/},
                onSearchClick = {/*todo*/},
                onProfileClick = { /*todo*/}
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    CircularProgressIndicator()
                }
            } else {
                if (errorMessage != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(ErrorColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = errorMessage ?: "",
                            color = Color.White,
                            style = androidx.compose.ui.text.TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        )
                    }
                }

                if (users.isEmpty()) {
                    Text("No users found", modifier = Modifier.align(Alignment.CenterHorizontally))
                } else {
                    UserList(
                        users = users,
                        onCardClick = { userId ->
                            Log.d("MainScreen", "Clicked user ID: $userId")
                        }
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        if (users.isEmpty()) {
            userViewModel.fetchUsers()
        }
    }
}

