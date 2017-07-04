package com.r15k.glacialware.r15k.ddbb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.r15k.glacialware.r15k.general.*

/**
 * Created by Tanuki on 04/07/2017.
 */



class DbHelper constructor(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {



    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(DB_CREATE_MISSION)
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DB_DELETE_MISSION)
        onCreate(p0)
    }

    override fun onDowngrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        onUpgrade(p0, p1, p2)
    }
}