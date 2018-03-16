package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index

/**
* Created by Guille on 15/11/2017.
*/
@Entity(
    tableName = "player_mission",
    indices = [Index("id_player"), Index("id_mission")],
    foreignKeys = [
        ForeignKey(
                entity = Player::class, parentColumns = ["id"], childColumns = ["id_player"],
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        ForeignKey(
                entity = Mission::class, parentColumns = ["id"], childColumns = ["id_mission"],
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    ],
    primaryKeys = ["id_player", "id_mission"]
)
data class PlayerMission (
    @ColumnInfo(name = "id_player")
    val idPlayer : Int,

    @ColumnInfo(name = "id_mission")
    val idMission : Int
)