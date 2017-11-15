package com.glacialware.r15k.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Guille on 15/11/2017.
 */
@Dao
interface GamePlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gamePlayer : GamePlayer)

    @Query("select * from game_player")
    fun getAll() : List<GamePlayer>
}