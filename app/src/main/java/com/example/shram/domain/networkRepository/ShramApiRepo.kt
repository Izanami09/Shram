package com.example.shram.domain.networkRepository

import com.example.shram.models.LeaderBoardResponse
import com.example.shram.models.LoginResponse
import com.example.shram.models.RegisterResponse
import com.example.shram.models.UserLoginDetails
import com.example.shram.models.UserRegisterDetails
import com.example.shram.models.shramdetails.RequestShramDetails
import com.example.shram.models.shramdetails.ResponseShramDetails

interface ShramApiRepo {
    suspend fun registerUser(userRegisterDetails: UserRegisterDetails) : RegisterResponse
    suspend fun loginUser(userLoginDetails: UserLoginDetails) : LoginResponse

    suspend fun getAllShram() : ResponseShramDetails

    suspend fun createShramdanEvent(requestShramDetails: RequestShramDetails) : RequestShramDetails

    suspend fun getLeaderBoard() : LeaderBoardResponse
}
