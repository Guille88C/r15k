package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Guille on 14/11/2017.
 */
@Entity (
        tableName = "mission",
        foreignKeys = arrayOf(ForeignKey(
        entity = Player::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_player")
)))
data class Mission (
        @PrimaryKey
        @ColumnInfo(name="id")
        val id : Int,

        @ColumnInfo(name = "title")
        val title : String,

        @ColumnInfo(name = "description")
        val description : String,

        @ColumnInfo(name = "image")
        val image : String,

        @ColumnInfo(name = "completed")
        var completed : Boolean,

        @ColumnInfo(name="id_player")
        var idPlayer : Int
)