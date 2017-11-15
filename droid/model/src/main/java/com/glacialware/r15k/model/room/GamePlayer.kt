package com.glacialware.r15k.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

/**
 * Created by Guille on 15/11/2017.
 */
@Entity (
    tableName = "game_player",
    foreignKeys = arrayOf(
        ForeignKey(entity = Game::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id_game")),
        ForeignKey(entity = Player::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id_player"))
    ),
    primaryKeys = arrayOf("id_game", "id_player")
)
data class GamePlayer (
    @ColumnInfo(name = "id_game")
    val idGame : String,

    @ColumnInfo(name = "id_player")
    val idPlayer : String
)