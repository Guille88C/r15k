package com.glacialware.r15k.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 * Created by Guille on 14/11/2017.
 */
@Dao
interface MissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(mission : Mission)

    @Query("select * from mission")
    fun getAll() : List<Mission>

    @Query("delete from mission")
    fun clear()
}