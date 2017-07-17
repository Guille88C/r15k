package com.r15k.glacialware.r15k.views.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.presenter.main.MainPresenter
import com.r15k.glacialware.r15k.presenter.main.MainPresenterImpl
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.TestActivity
import com.r15k.glacialware.r15k.views.addPlayer.AddPlayerActivity
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : GenericRootActivity(), View.OnClickListener, AdapterView.OnItemClickListener, MainView {

    // ==== ATTRIBUTES ====
    private lateinit var mDrawerToggle : ActionBarDrawerToggle
    private lateinit var mPresenter: MainPresenter
    // ==== ---- ====




    // ==== LIFE CYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onBackPressed() {
        mPresenter.onBackPressed()
    }
    // ==== ---- ====




    // ==== GENERIC ROOT FUNCTIONS ====
    override fun inflateLayout() {
        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)
    }

    override fun init() {
        initFragment()
        initToolbar()
        initMenu()

        this.mPresenter = MainPresenterImpl(this)
    }
    // ==== ---- ====




    // ==== INIT FUNCTIONS ====
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
        val menuItems : Array<String> = resources.getStringArray(R.array.menu_items)
        val menuAdapter : MenuAdapter = MenuAdapter(this, R.layout.view_drawer_menu_main_item, arrayListOf(MenuItem(menuItems[0]), MenuItem(menuItems[1])))
        leftDrawer.adapter = menuAdapter

        this.mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(this.mDrawerToggle)

        leftDrawer.onItemClickListener = this
    }
    //==== ---- ====




    // ==== LISTENERS ====
    override fun onClick(p0: View?) {
        mPresenter.onClick()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        mPresenter.onItemClick(p2)
    }
    // ==== ---- ====




    //==== MAIN VIEW FUNCTIONS ====
    override fun closeDrawer() {
        drawerLayout.closeDrawer(Gravity.START)
    }

    override fun isDrawerOpen() : Boolean {
        return drawerLayout.isDrawerOpen(Gravity.START)
    }

    override fun addDrawerListener(listener : DrawerLayout.DrawerListener) {
        drawerLayout.addDrawerListener(listener)
    }

    override fun removeDrawerListener(listener : DrawerLayout.DrawerListener) {
        drawerLayout.removeDrawerListener(listener)
    }

    override fun superOnBackPressed() {
        super.onBackPressed()
    }

    override fun navigateToTest() {
        navigateTo(this, TestActivity :: class.java)
    }

    override fun navigateToAddPlayer() {
        navigateTo(this, AddPlayerActivity :: class.java)
    }
    // ==== ---- ====

}