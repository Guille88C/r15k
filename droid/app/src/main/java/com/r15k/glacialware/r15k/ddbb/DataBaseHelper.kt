package com.r15k.glacialware.r15k.ddbb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.r15k.glacialware.r15k.general.*

/**
 * Created by Tanuki on 04/07/2017.
 */
class DataBaseHelper constructor(context: Context?) : SQLiteOpenHelper(context, DDBB_NAME, null, DDBB_VERSION) {



    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDowngrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}