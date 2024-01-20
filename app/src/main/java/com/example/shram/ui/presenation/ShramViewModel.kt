package com.example.shram.ui.presenation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shram.data.NetworkShramApiImplementation
import com.example.shram.models.UserLoginDetails
import com.example.shram.models.UserRegisterDetails
import com.example.shram.models.shramdetails.RequestShramDetails
import com.example.shram.ui.shramUIState.ShramUiState
import com.example.shram.util.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ShramViewModel @Inject constructor(
    private val networkShramApiImplementation: NetworkShramApiImplementation
) : ViewModel() {
    private val _shramUiState = MutableStateFlow(ShramUiState())
    val shramUiState : StateFlow<ShramUiState> = _shramUiState.asStateFlow()
    //loginScreen
    var loginDetails by mutableStateOf(
        UserLoginDetails(
            number = "",
            password = ""
        )
    )


    //registerScreen
    var registerDetail by mutableStateOf(UserRegisterDetails(
            name = "",
            age = "",
            number = "",
            address = "",
            gender = "",
            password = ""
        )
    )

     fun registerUser(){
        viewModelScope.launch{
            val response = networkShramApiImplementation.registerUser(registerDetail)
            _shramUiState.update {
                it.copy(
                    userRegisterMessage = response.msg.toString()
                )
            }
        }
    }
    
    fun loginUser(){
        viewModelScope.launch(Dispatchers.IO){
            val response = networkShramApiImplementation.loginUser(loginDetails)
            _shramUiState.update {
                it.copy(
                    isUserLoggedIn = true,
                    loginResponse = response
                )
            }

            }
        }


    //shramfeed
    fun getAllShram(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = networkShramApiImplementation.getAllShram()
            _shramUiState.update {
                it.copy(
                    allShram = response
                )
            }
        }
    }
    //createShram

    var createShramdan by mutableStateOf(RequestShramDetails(
        userId = "",
        title = "",
        description = "",
        date = "",
        location = ""
        )
    )
    var date by mutableStateOf("")
    var userTime by mutableStateOf("")

    val util : Util = Util()
    @RequiresApi(Build.VERSION_CODES.O)

    fun createShramdanEvent(){
        viewModelScope.launch {
            networkShramApiImplementation.createShramdanEvent(createShramdan)
        }
    }

    //MapsScreen

}






