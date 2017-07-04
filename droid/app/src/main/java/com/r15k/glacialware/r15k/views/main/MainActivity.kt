package com.r15k.glacialware.r15k.views.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.ddbb.DbManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : AppCompatActivity() {

    lateinit var dbManager : DbManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)


        dbManager = DbManager(this)
        dbManager.saveMission(
                "Mission test",
                "This is my first mission",
                "",
                true
        )

        textView.text = "your mother is a fucker"

    }

    override fun onDestroy() {

        dbManager.close()

        super.onDestroy()
    }

}