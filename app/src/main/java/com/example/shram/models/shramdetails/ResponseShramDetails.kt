package com.example.shram.models.shramdetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



@Serializable
data class ResponseShramDetails(
    val jobs: List<ShramDetails>,
)
@Serializable
data class ShramDetails(
    @SerialName("__id")var id : String,
    var title : String,
    var description : String,
    var date : String,
    var location : String,
    var verified : Boolean,
    var createdAt : String,
    var updatedAt : String,
    @SerialName("__v")var version : String
)
