package com.example.shram.network

import com.example.shram.models.LeaderBoardResponse
import com.example.shram.models.LoginResponse
import com.example.shram.models.RegisterResponse
import com.example.shram.models.UserLoginDetails
import com.example.shram.models.UserRegisterDetails
import com.example.shram.models.shramdetails.RequestShramDetails
import com.example.shram.models.shramdetails.ResponseShramDetails
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ShramApiService {
    @POST("/api/v1/auth/register")
    suspend fun registerUser(
        @Body userRegisterDetails: UserRegisterDetails
    ) : RegisterResponse

    @POST("/api/v1/auth/login")
    suspend fun loginUser(
        @Body userLoginDetails: UserLoginDetails
    ) : LoginResponse

    @POST("/api/v1/job")
    suspend fun createShram(@Body createJobDetails: RequestShramDetails) : RequestShramDetails

    @GET("/api/v1/job")
    suspend fun getAllShram() : ResponseShramDetails

    @GET("/api/v1/leaderboard")
    suspend fun getLeaderboard() : LeaderBoardResponse

}