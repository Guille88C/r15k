package com.glacialware.r15k.model.room

import android.arch.persistence.room.*

/**
* Created by Guille on 14/11/2017.
*/
@Entity (
    tableName = "mission"
)
data class Mission (
    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "description")
    val description : String,

    @ColumnInfo(name = "image")
    val image : String,

    @ColumnInfo(name = "completed")
    val completed : Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0
}