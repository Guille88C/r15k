package com.r15k.glacialware.r15k.ddbb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

/**
 * Created by Tanuki on 04/07/2017.
 */
class DbManager constructor(context : Context) {

    val helper : DbHelper = DbHelper(context)
    val db : SQLiteDatabase = helper.writableDatabase

    fun saveMission(title : String, description : String, image : String, completed : Boolean) {

        val values : ContentValues = ContentValues()
        values.put(DB_MISSION_COLUMN_ID, 0)
        values.put(DB_MISSION_COLUMN_TITLE, title)
        values.put(DB_MISSION_COLUMN_DESCRIPTION, description)
        values.put(DB_MISSION_COLUMN_IMAGE, image)
        values.put(DB_MISSION_COLUMN_COMPLETED, completed)

        db.insert(DB_MISSION_TABLE_NAME, null, values)

    }

    fun close() {
        helper.close()
    }

}