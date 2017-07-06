package com.r15k.glacialware.r15k.ddbb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.r15k.glacialware.r15k.models.Game
import com.r15k.glacialware.r15k.models.Mission
import com.r15k.glacialware.r15k.models.Player

/**
 * Created by Tanuki on 04/07/2017.
 */
class DbManager constructor(context : Context) {

    val helper : DbHelper = DbHelper(context)
    val dbWriter : SQLiteDatabase = helper.writableDatabase
    val dbReader : SQLiteDatabase = helper.writableDatabase

    private fun savePlayer(db : SQLiteDatabase, player : Player) {

        val values : ContentValues = ContentValues()
        values.put(DB_PLAYER_COLUMN_NICK, player.nick)
        values.put(DB_PLAYER_COLUMN_IS_DEAD, player.isDead)

        db.insert(DB_PLAYER_TABLE_NAME, null, values)

    }

    private fun saveMission(db : SQLiteDatabase, mission : Mission) {

        val values : ContentValues = ContentValues()
        values.put(DB_MISSION_COLUMN_TITLE, mission.title)
        values.put(DB_MISSION_COLUMN_DESCRIPTION, mission.description)
        values.put(DB_MISSION_COLUMN_IMAGE, mission.image)
        values.put(DB_MISSION_COLUMN_COMPLETED, mission.completed)

        db.insert(DB_MISSION_TABLE_NAME, null, values)

    }

    fun saveGame(game : Game) {

        val db : SQLiteDatabase = helper.writableDatabase

        for (player : Player in game.lPlayers) {
            savePlayer(db, player)
            for (mission : Mission in player.lMissions) {
                saveMission(db, mission)
            }
        }

        db.close()
    }

    fun getGame() : Game {

        val db : SQLiteDatabase = helper.readableDatabase

        val columns : Array<String> = arrayOf(DB_PLAYER_COLUMN_ID, DB_PLAYER_COLUMN_NICK, DB_PLAYER_COLUMN_IS_DEAD)
//        val selection = FeedEntry.COLUMN_NAME_TITLE + " = ?"
//        val selectionArgs = arrayOf("My Title")

        val cursor = db.query(
                DB_PLAYER_TABLE_NAME,
                columns,
                null,
                null,
                null, null, null
        )

        val players : Array<Player>

        while (cursor.moveToNext()) {
            val itemId = cursor.getLong(cursor.getColumnIndexOrThrow(DB_PLAYER_COLUMN_ID))
        }

        cursor.close()

        db.close()

        val game : Game = Game()
        return game

    }

    fun close() {
        helper.close()
    }

}