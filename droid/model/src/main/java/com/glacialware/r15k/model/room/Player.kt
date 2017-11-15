package com.glacialware.r15k.model.room

import android.arch.persistence.room.*

/**
 * Created by Guille on 14/11/2017.
 */
@Entity (
    tableName = "player"
)
data class Player (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int,

    @ColumnInfo(name = "nick")
    val nick : String,

    @ColumnInfo(name = "is_dead")
    val isDead : Boolean
)