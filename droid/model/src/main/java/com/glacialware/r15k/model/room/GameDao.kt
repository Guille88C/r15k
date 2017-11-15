package com.glacialware.r15k.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Guille on 14/11/2017.
 */
@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game : Game)

    @Query("select * from game")
    fun getAll() : List<Game>

    @Query("delete from game")
    fun clear()
}