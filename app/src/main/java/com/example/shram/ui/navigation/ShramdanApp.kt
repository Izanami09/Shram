package com.example.shram.ui.navigation


import android.app.Instrumentation.ActivityResult
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.shram.ui.presenation.ShramViewModel
import com.example.shram.ui.presenation.homescreen.HomeScreen
import com.example.shram.ui.presenation.loginscreen.LoginScreen
import com.example.shram.ui.presenation.registerscreen.RegisterScreen
import com.example.shram.ui.presenation.shramscreen.CreateShramDanScreen
import com.example.shram.ui.presenation.shramscreen.ShramScreen
import com.example.shram.ui.shramUIState.ShramUiState


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShramdanApp(
    shramViewModel: ShramViewModel
) {
    val shramUiState by shramViewModel.shramUiState.collectAsState()
    val navController = rememberNavController()
    ShramdanNavHost(shramViewModel = shramViewModel, shramUiState = shramUiState, navController = navController)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShramdanNavHost(
    shramViewModel: ShramViewModel,
    shramUiState: ShramUiState,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                viewModel = shramViewModel
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.name,
            modifier = Modifier.padding(it)
        ) {
            //homeScreen
            composable(route = Screen.HomeScreen.name){
                HomeScreen(
                    viewModel = shramViewModel,
                    uiState = shramUiState,
                    onExploringButtonClicked = {navController.navigate(Screen.ShramFeed.name)},
                    onLoginOrSignupClicked = {navController.navigate(Screen.Login.name)}
                )
            }
            //login screen
            composable(route = Screen.Login.name) {
                LoginScreen(
                    shramViewModel = shramViewModel,
                    onLoginClick = {shramViewModel.loginUser()},
                    onRegisterClick = {navController.navigate(Screen.Register.name)}
                )
            }
            //register screen
            composable(route = Screen.Register.name){
                RegisterScreen(shramViewModel = shramViewModel)
            }

            //feedScreen
            composable(route = Screen.ShramFeed.name){
                ShramScreen(
                    viewModel = shramViewModel,
                    shramUiState = shramUiState,
                    onCreateEventClick = {navController.navigate(Screen.CreateShramdanEvent.name)}
                )
            }

            //createSharamdanEven
            composable(route = Screen.CreateShramdanEvent.name){
                CreateShramDanScreen(
                    shramViewModel = shramViewModel,
                    shramUiState = shramUiState,
                    navController = navController
                )
            }
            //Map Screen
            composable(route = Screen.MapScreen.name){

            }
            }
        }
    }


