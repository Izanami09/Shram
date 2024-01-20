package com.example.shram.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    var role : String,
    var userId : String,
    var name: String
)