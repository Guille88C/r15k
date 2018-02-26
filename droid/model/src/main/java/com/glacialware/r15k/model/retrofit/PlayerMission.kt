package com.glacialware.r15k.model.retrofit

import com.google.gson.annotations.SerializedName

/**
* Created by Guille on 28/11/2017.
*/
data class PlayerMission(
    @SerializedName("id_player")
    val idPlayer: Int,
    @SerializedName("id_mission")
    val idMission: Int
)