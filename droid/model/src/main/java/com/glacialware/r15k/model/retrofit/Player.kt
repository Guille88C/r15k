package com.glacialware.r15k.model.retrofit

import com.google.gson.annotations.SerializedName

/**
* Created by Guille on 28/11/2017.
*/
data class Player(
    val id: Int,
    val nick: String,
    @SerializedName("is_dead")
    val isDead: Boolean
) : BaseEntity() {
    fun exportRoom(): com.glacialware.r15k.model.room.Player {
        return com.glacialware.r15k.model.room.Player(
                this.nick,
                this.isDead
        )
    }
}
