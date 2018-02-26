package com.glacialware.r15k.model.room

import android.arch.persistence.room.*
import java.io.Serializable

/**
* Created by Guille on 14/11/2017.
*/
@Entity (
    tableName = "player"
)
data class Player (
    @ColumnInfo(name = "nick")
    val nick : String,

    @ColumnInfo(name = "is_dead")
    val isDead : Boolean
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0
}