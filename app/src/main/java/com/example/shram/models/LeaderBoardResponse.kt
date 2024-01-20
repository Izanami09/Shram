package com.example.shram.models

import kotlinx.serialization.Serializable


@Serializable
data class LeaderBoardResponse(
    val leaderboard : List<LeaderBoard>
)


@Serializable
data class LeaderBoard(
    val name:String,
    val address:String,
    val points:String
)
