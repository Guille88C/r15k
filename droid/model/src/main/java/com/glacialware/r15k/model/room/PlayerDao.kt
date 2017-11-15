package com.glacialware.r15k.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Guille on 14/11/2017.
 */
@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(player : Player)

    @Query("select * from player")
    fun getAll() : List<Player>

    @Query("delete from player")
    fun clear()
}