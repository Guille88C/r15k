package com.r15k.glacialware.r15k.views.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.ddbb.DbManager
import com.r15k.glacialware.r15k.models.Game
import com.r15k.glacialware.r15k.models.Mission
import com.r15k.glacialware.r15k.models.Player
import com.r15k.glacialware.r15k.presenter.main.MainPresenter
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.TestActivity
import com.r15k.glacialware.r15k.views.addPlayer.AddPlayerActivity
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : GenericRootActivity(), View.OnClickListener, AdapterView.OnItemClickListener {
    // ==== ATTRIBUTES ====
    lateinit var dbManager : DbManager
    lateinit var mDrawerToggle : ActionBarDrawerToggle
    lateinit var mPresenter : MainPresenter
    // ==== ---- ====

    // ==== LIFE CYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        dbManager.close()

        super.onDestroy()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        this.mDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        this.mDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (this.mDrawerToggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }
    // ==== ---- ====

    // ==== GENERIC ====
    override fun inflateLayout() {
        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)
    }

    override fun init() {
        this.mPresenter = MainPresenter(this)

        this.initToolbar()
        this.initMenu()
        this.initFragment()
        this.initDB()
    }
    // ==== ---- ====

    // ==== LISTENERS ====
    override fun onClick(p0: View?) {
        navigateTo(this, TestActivity :: class.java)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val menuOption : MainPresenter.MenuOption = this.mPresenter.getMenuOption(p2)
        when (menuOption) {
            MainPresenter.MenuOption.ADD_PLAYER -> navigateTo(this, AddPlayerActivity :: class.java)
            MainPresenter.MenuOption.START_GAME -> {}
            MainPresenter.MenuOption.NONE -> {}
        }
    }
    // ==== ---- ====

    // ==== PRIVATE ====
    private fun initFragment() {
        navigateTo(supportFragmentManager, PlayersFragment.newInstance(), PlayersFragment.TAG, R.id.activity_main_content_frame, true, false)
    }

    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }

    private fun initMenu() {
        val list : ArrayList<com.r15k.glacialware.r15k.views.main.MenuItem> = this.mPresenter.getMenuData()
        val menuAdapter : MenuAdapter = MenuAdapter(this, R.layout.view_drawer_menu_main_item, list)
        leftDrawer.adapter = menuAdapter

        this.mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(this.mDrawerToggle)

        leftDrawer.onItemClickListener = this
    }

    private fun initDB() {

        val players : MutableList<Player> = mutableListOf()
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
    // ==== ---- ====
}