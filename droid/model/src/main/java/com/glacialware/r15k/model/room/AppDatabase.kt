package com.glacialware.r15k.model.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Guille on 14/11/2017.
 */
@Database(
        entities = arrayOf(Mission::class, Player::class, Game::class),
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun missionDao() : MissionDao
    abstract fun playerDao() : PlayerDao
    abstract fun gameDao() : GameDao
}