package com.r15k.glacialware.r15k.datastore.ddbb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.r15k.glacialware.r15k.entities.Mission
import com.r15k.glacialware.r15k.entities.Player

/**
 * Created by Tanuki on 04/07/2017.
 */
class DbManager constructor(context : Context) {

    private val helper : DbHelper = DbHelper(context)

    fun close() {
        helper.close()
    }




    fun savePlayer(player : Player) {

        val values : ContentValues = ContentValues()
        values.put(DB_PLAYER_COLUMN_NICK, player.nick)
        values.put(DB_PLAYER_COLUMN_IS_DEAD, player.isDead)

        val db : SQLiteDatabase = helper.writableDatabase
        db.insert(DB_PLAYER_TABLE_NAME, null, values)
        db.close()

    }

    fun updatePlayer(player : Player) {

        val values : ContentValues = ContentValues()
        values.put(DB_PLAYER_COLUMN_NICK, player.nick)
        values.put(DB_PLAYER_COLUMN_IS_DEAD, player.isDead)

        val selection = DB_PLAYER_COLUMN_ID + " LIKE ?"
        val selectionArgs = arrayOf(player.id.toString())

        val db : SQLiteDatabase = helper.writableDatabase
        db.update(DB_PLAYER_TABLE_NAME, values, selection, selectionArgs)
        db.close()

    }

    fun getPlayers() : MutableList<Player> {

        val db : SQLiteDatabase = helper.readableDatabase
        val cursor : Cursor = db.query(DB_PLAYER_TABLE_NAME, null, null, null, null, null, null)

        val players : MutableList<Player> = mutableListOf()
        while (cursor.moveToNext()) {
            val id : Int = cursor.getInt(0)
            val name : String = cursor.getString(1)
            val isDead : Boolean = cursor.getInt(2) == 1
            players.add(Player(id, name, mutableListOf<Mission>(), isDead))
        }

        cursor.close()
        db.close()

        return players

    }

    fun deletePlayer(id : Int) {

        val selection = DB_PLAYER_COLUMN_ID + " LIKE ?"
        val selectionArgs : Array<String> = arrayOf(id.toString())

        val db : SQLiteDatabase = helper.writableDatabase
        db.delete(DB_PLAYER_TABLE_NAME, selection, selectionArgs)
        db.close()

    }

    fun deletePlayers() {

        val db : SQLiteDatabase = helper.writableDatabase
        db.delete(DB_PLAYER_TABLE_NAME, null, null)
        db.close()
    }




    fun saveMission(mission : Mission) {

        val values : ContentValues = ContentValues()
        values.put(DB_MISSION_COLUMN_TITLE, mission.title)
        values.put(DB_MISSION_COLUMN_DESCRIPTION, mission.description)
        values.put(DB_MISSION_COLUMN_IMAGE, mission.image)
        values.put(DB_MISSION_COLUMN_COMPLETED, mission.completed)
        values.put(DB_MISSION_COLUMN_ID_PLAYER, mission.idPlayer)

        val db : SQLiteDatabase = helper.writableDatabase
        db.insert(DB_MISSION_TABLE_NAME, null, values)
        db.close()

    }

    fun updateMission(mission : Mission) {

        val values : ContentValues = ContentValues()
        values.put(DB_MISSION_COLUMN_TITLE, mission.title)
        values.put(DB_MISSION_COLUMN_DESCRIPTION, mission.description)
        values.put(DB_MISSION_COLUMN_IMAGE, mission.image)
        values.put(DB_MISSION_COLUMN_COMPLETED, mission.completed)
        values.put(DB_MISSION_COLUMN_ID_PLAYER, mission.idPlayer)

        val selection : String = DB_MISSION_COLUMN_ID + " LIKE ?"
        val selectionArgs : Array<String> = arrayOf(mission.id.toString())

        val db : SQLiteDatabase = helper.writableDatabase
        db.update(DB_MISSION_TABLE_NAME, values, selection, selectionArgs)
        db.close()

    }

    fun getMissions(idPlayer : Int) : MutableList<Mission> {

        val selection : String = DB_MISSION_COLUMN_ID_PLAYER + " LIKE ?"
        val selectionArgs : Array<String> = arrayOf(idPlayer.toString())

        val db : SQLiteDatabase = helper.readableDatabase
        val cursor : Cursor = db.query(
                DB_MISSION_TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        )

        val missions : MutableList<Mission> = mutableListOf()
        while (cursor.moveToNext()) {
            val id : Int = cursor.getInt(0)
            val title : String = cursor.getString(1)
            val description : String = cursor.getString(2)
            val image : String = cursor.getString(3)
            val completed : Boolean = cursor.getInt(4) == 1
            val idPlayer : Int = cursor.getInt(5)
            missions.add(Mission(id, title, description, image, completed, idPlayer))
        }

        cursor.close()
        db.close()

        return missions

    }

    fun deleteMission(id : Int) {

        val selection : String = DB_MISSION_COLUMN_ID + " LIKE ?"
        val selectionArgs : Array<String> = arrayOf(id.toString())

        val db : SQLiteDatabase = helper.writableDatabase
        db.delete(DB_MISSION_TABLE_NAME, selection, selectionArgs)
        db.close()

    }

    fun deleteMissions() {

        val db : SQLiteDatabase = helper.writableDatabase
        db.delete(DB_MISSION_TABLE_NAME, null, null)
        db.close()

    }

}