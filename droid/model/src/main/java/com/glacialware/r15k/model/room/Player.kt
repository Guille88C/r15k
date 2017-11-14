package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.glacialware.r15k.view.entities.Mission

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

        @ColumnInfo(name = "list_missions")
        var lMissions : ArrayList<Mission>,

        @ColumnInfo(name = "is_dead")
        var isDead : Boolean
)