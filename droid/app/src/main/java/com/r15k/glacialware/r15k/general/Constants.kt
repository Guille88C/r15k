package com.r15k.glacialware.r15k.general

/**
 * Created by Tanuki on 04/07/2017.
 */

// Data base
val DB_VERSION : Int = 1
val DB_NAME : String = "r15k.db"

val DB_MISSION_TABLE_NAME : String = "mission"
val DB_MISSION_COLUMN_ID : String = "id"
val DB_MISSION_COLUMN_TITLE : String = "title"
val DB_MISSION_COLUMN_DESCRIPTION : String = "description"
val DB_MISSION_COLUMN_IMAGE : String = "image"
val DB_MISSION_COLUMN_COMPLETED : String = "completed"

val DB_CREATE_MISSION : String = "CREATE TABLE " + DB_MISSION_TABLE_NAME + " (" +
        DB_MISSION_COLUMN_ID + " INTEGER PRIMARY KEY," +
        DB_MISSION_COLUMN_TITLE + " TEXT," +
        DB_MISSION_COLUMN_DESCRIPTION + " TEXT," +
        DB_MISSION_COLUMN_IMAGE + " TEXT," +
        DB_MISSION_COLUMN_COMPLETED + " NUMERIC)"

val DB_DELETE_MISSION : String = "DROP TABLE IF EXISTS " + DB_MISSION_TABLE_NAME