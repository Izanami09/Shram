package com.example.shram.models.shramdetails

import kotlinx.serialization.Serializable

@Serializable
data class RequestShramDetails (
    var userId : String,
    var title : String,
    var description : String,
    var date: String,
    var location : String
)