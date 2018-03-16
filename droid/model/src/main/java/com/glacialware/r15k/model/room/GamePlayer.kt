package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index

/**
* Created by Guille on 15/11/2017.
*/
@Entity (
    tableName = "game_player",
    indices = [(Index("id_player"))],
    foreignKeys = [
        ForeignKey(
                entity = Game::class, parentColumns = ["id"], childColumns = ["id_game"],
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        ForeignKey(
                entity = Player::class, parentColumns = ["id"], childColumns = ["id_player"],
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    ],
    primaryKeys = ["id_game", "id_player"]
)
data class GamePlayer (
    @ColumnInfo(name = "id_game")
    val idGame : String,

    @ColumnInfo(name = "id_player")
    val idPlayer : String
)