package com.r15k.glacialware.r15k.views.main

import android.os.Bundle
import android.view.View
import com.r15k.glacialware.r15k.ddbb.DbManager
import com.r15k.glacialware.r15k.models.Game
import com.r15k.glacialware.r15k.models.Mission
import com.r15k.glacialware.r15k.models.Player
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.TestActivity
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : GenericRootActivity(), View.OnClickListener {

    lateinit var dbManager : DbManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        dbManager.close()

        super.onDestroy()
    }

    override fun inflateLayout() {
        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)
    }

    override fun init() {
        textView.text = "preparing view... be patient... don't worry, be happy :D :D"
        testButton.setOnClickListener(this)
        this.initDB()
    }

    override fun onClick(p0: View?) {
        navigateTo(this, TestActivity :: class.java)
    }

    private fun initDB() {

        var players : MutableList<Player> = mutableListOf()
        var i : Int = 0
        while (i < 4) {

            val missions : MutableList<Mission> = mutableListOf()
            var j : Int = 0
            while (j < 2) {

                val mission : Mission = Mission(j, "title " + j, "description " + j, "", false, i)
                missions.add(mission)
                j++

            }

            val player : Player = Player(i, "player " + i, missions, false)
            players.add(player)
            i ++

        }

        val game : Game = Game(players)

        dbManager = DbManager(this)
        dbManager.saveGame(game)
    }
}