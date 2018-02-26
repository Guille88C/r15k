package com.glacialware.r15k.model.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
* Created by Guille on 14/11/2017.
*/
@Database(
    entities = arrayOf(Mission::class, Player::class, Game::class, PlayerMission::class, GamePlayer::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun missionDao() : MissionDao
    abstract fun playerDao() : PlayerDao
    abstract fun gameDao() : GameDao
    abstract fun playerMissionDao() : PlayerMissionDao
    abstract fun gamePlayerDao() : GamePlayerDao

    fun clearAllTables() {
        gameDao().clear()
        playerDao().clear()
        missionDao().clear()
        gamePlayerDao().clear()
        playerMissionDao().clear()
    }

    fun createFakeData() {
        val mission1 = Mission(0, "mission title 1", "mission desc 1", "image 1", false)
        val mission2 = Mission(1, "mission title 2", "mission desc 2", "image 2", false)
        missionDao().insert(mission1)
        missionDao().insert(mission2)

        val playerRoom1 = Player("player 1", false)
        val playerRoom2 = Player("player 2", false)
        playerDao().insert(playerRoom1)
        playerDao().insert(playerRoom2)

        val playerMission1 = PlayerMission(0, 1)
        val playerMission2 = PlayerMission(1, 0)
        playerMissionDao().insert(playerMission1)
        playerMissionDao().insert(playerMission2)
    }
}