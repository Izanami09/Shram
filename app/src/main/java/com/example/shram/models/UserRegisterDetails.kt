package com.example.shram.models

import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterDetails(
    var name : String,
    var age : String,
    var number : String,
    var address : String,
    var gender : String,
    var password : String
)