package com.r15k.glacialware.r15k.views.main

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.ddbb.DbHelper
import com.r15k.glacialware.r15k.general.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)


        val helper : DbHelper = DbHelper(this)
        val db : SQLiteDatabase = helper.writableDatabase
        val values : ContentValues = ContentValues()
        values.put(DB_MISSION_COLUMN_ID, 0)
        values.put(DB_MISSION_COLUMN_TITLE, "test 1")
        values.put(DB_MISSION_COLUMN_DESCRIPTION, "This is my first description")
        values.put(DB_MISSION_COLUMN_IMAGE, "")
        values.put(DB_MISSION_COLUMN_COMPLETED, true)
        db.insert(DB_MISSION_TABLE_NAME, null, values)

        textView.text = "your mother is a fucker"

    }

}