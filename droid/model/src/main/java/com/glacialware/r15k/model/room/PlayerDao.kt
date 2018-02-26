package com.glacialware.r15k.model.room

import android.arch.persistence.room.*

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

    @Delete
    fun delete(player: Player)
}