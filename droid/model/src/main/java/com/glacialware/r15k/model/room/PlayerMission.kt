package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

/**
 * Created by Guille on 15/11/2017.
 */
@Entity(
    tableName = "player_mission",
    foreignKeys = arrayOf(
        ForeignKey(entity = Player::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id_player")),
        ForeignKey(entity = Mission::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id_mission"))
    ),
    primaryKeys = arrayOf("id_player", "id_mission")
)
data class PlayerMission (
    @ColumnInfo(name = "id_player")
    val idPlayer : Int,

    @ColumnInfo(name = "id_mission")
    val idMission : Int
)