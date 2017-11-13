package com.r15k.glacialware.r15k.views.main

import android.content.res.Configuration
import android.content.res.TypedArray
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.presenters.main.MainPresenter
import com.r15k.glacialware.r15k.presenters.main.MainPresenterImpl
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : GenericRootActivity(), MainView {

    // ==== ATTRIBUTES ====
    private lateinit var mDrawerToggle : ActionBarDrawerToggle
    private lateinit var mPresenter: MainPresenter
    // ==== ---- ====




    // ==== LIFE CYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)

        initToolbar()
        initMenu()

        mPresenter = MainPresenterImpl(this)
        mPresenter.initPresenter()
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




    // ==== INIT FUNCTIONS ====
    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }

    private fun initMenu() {
        this.mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(this.mDrawerToggle)

        leftDrawer.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mPresenter.onItemClick(p2)
            }
        }
    }
    //==== ---- ====




    //==== MAIN VIEW FUNCTIONS ====
    override fun initDrawerStrings(res: Int) {
        if (isCreated()) {
            val textItems : Array<String> = resources.getStringArray(res)
            val drawableItems : TypedArray = resources.obtainTypedArray(R.array.drawable_menu_items)
            val menuAdapter : MenuAdapter = MenuAdapter(this@MainActivity, Array(textItems.size, { i -> MenuItem(textItems[i], drawableItems.getResourceId(0, R.drawable.default_menu_item))}))
            drawableItems.recycle()
            leftDrawer.adapter = menuAdapter
        }
    }

    override fun closeDrawer() {
        if (isCreated()) {
            drawerLayout.closeDrawer(Gravity.START)
        }
    }

    override fun isDrawerOpen() : Boolean {
        if (isCreated()) {
            return drawerLayout.isDrawerOpen(Gravity.START)
        }
        return false
    }

    override fun addDrawerListener(listener : DrawerLayout.DrawerListener) {
        if (isCreated()) {
            drawerLayout.addDrawerListener(listener)
        }
    }

    override fun removeDrawerListener(listener : DrawerLayout.DrawerListener) {
        if (isCreated()) {
            drawerLayout.removeDrawerListener(listener)
        }
    }

    override fun superOnBackPressed() {
        if (isCreated()) {
            super.onBackPressed()
        }
    }
    // ==== ---- ====

}