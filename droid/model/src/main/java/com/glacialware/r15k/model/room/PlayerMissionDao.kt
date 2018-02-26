package com.glacialware.r15k.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
* Created by Guille on 15/11/2017.
*/
@Dao
interface PlayerMissionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerMission : PlayerMission)

    @Query("select * from player_mission")
    fun getAll() : List<PlayerMission>

    @Query("delete from player_mission")
    fun clear()
}