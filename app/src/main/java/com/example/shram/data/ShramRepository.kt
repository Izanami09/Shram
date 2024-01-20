package com.example.shram.data

import com.example.shram.domain.networkRepository.ShramApiRepo
import com.example.shram.models.LeaderBoardResponse
import com.example.shram.models.LoginResponse
import com.example.shram.models.RegisterResponse
import com.example.shram.models.UserLoginDetails
import com.example.shram.models.UserRegisterDetails
import com.example.shram.models.shramdetails.RequestShramDetails
import com.example.shram.models.shramdetails.ResponseShramDetails
import com.example.shram.network.ShramApiService
import javax.inject.Inject

class NetworkShramApiImplementation @Inject constructor(private val shramApiService: ShramApiService): ShramApiRepo{
    override suspend fun registerUser(userRegisterDetails: UserRegisterDetails): RegisterResponse {
        return shramApiService.registerUser(userRegisterDetails)
    }

    override suspend fun loginUser(userLoginDetails: UserLoginDetails): LoginResponse {
        return shramApiService.loginUser(userLoginDetails)
    }

    override suspend fun getAllShram(): ResponseShramDetails {
        return shramApiService.getAllShram()
    }

    override suspend fun createShramdanEvent(craeteEvnetDetails: RequestShramDetails): RequestShramDetails {
        return shramApiService.createShram(craeteEvnetDetails)
    }

    override suspend fun getLeaderBoard(): LeaderBoardResponse {
        return shramApiService.getLeaderboard()
    }


}

