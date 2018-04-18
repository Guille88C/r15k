package com.glacialware.r15k.model.retrofit

/**
* Created by Guille on 28/11/2017.
*/
data class Mission(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val completed: Boolean
) : BaseEntity() {

    fun exportRoom(): com.glacialware.r15k.model.room.Mission {
        return com.glacialware.r15k.model.room.Mission(
                this.title,
                this.description,
                this.image,
                this.completed
        )
    }

}