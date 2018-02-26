package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
* Created by Guille on 14/11/2017.
*/
@Entity(
    tableName = "game"
)
data class Game (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int
)