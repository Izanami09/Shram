package com.example.shram.ui.shramUIState

import com.example.shram.models.LoginResponse
import com.example.shram.models.shramdetails.ResponseShramDetails

data class ShramUiState(
   var userRegisterMessage : String = "",
   var isUserLoggedIn : Boolean = false,
   var allShram : ResponseShramDetails = ResponseShramDetails(
      jobs = listOf()
   ),
   var loginResponse: LoginResponse = LoginResponse("", "", "Guest")

)