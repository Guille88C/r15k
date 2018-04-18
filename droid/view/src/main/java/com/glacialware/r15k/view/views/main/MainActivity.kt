package com.glacialware.r15k.view.views.main

import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.content.res.TypedArray
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.crashlytics.android.Crashlytics
import com.glacialware.r15k.view.wireframes.main.MainActivityWireframe
import com.glacialware.r15k.viewmodel.views.main.MainViewModel
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

/**
* Created by Guille on 01/07/2017.
*/
class MainActivity : GenericRootActivity<MainViewModel>() {

    // ---- Companion ----

    companion object {
        private const val ADD_PLAYER = 0
        private const val ALL_CARDS = 1
        private const val START_GAME = 2
        private const val TEST_ACTIVITY = 3
    }

    // ---- END Companion ----

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireFrame: MainActivityWireframe
    // ---- END Dagger attributes ----

    // ---- Attributes ----

    private lateinit var mDrawerToggle : ActionBarDrawerToggle

    // ---- END Attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
        mActivityComponent.inject(this)
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun initView() {
        Fabric.with(this, Crashlytics())
        setContentView(com.glacialware.r15k.view.R.layout.activity_main)

        initDrawerStrings(R.array.text_menu_items)
        initMenu()
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
        if (isDrawerOpen()) {
            closeDrawer()
        }
        else {
            superOnBackPressed()
        }
    }

    // ---- END GenericRootActivity ----

    // ---- Private ----

    private fun initMenu() {
        this.mDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(this.mDrawerToggle)

        leftDrawer.onItemClickListener = AdapterView.OnItemClickListener { _, _, pos, _ ->
            closeDrawer()
            addDrawerListener(object: DrawerLayout.DrawerListener {
                override fun onDrawerStateChanged(newState: Int) {
                }

                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                }

                override fun onDrawerClosed(drawerView: View) {
                    when (pos) {
                        ADD_PLAYER -> mWireFrame.goToAddPlayer()
                        ALL_CARDS -> mWireFrame.goToCards()
                        START_GAME -> {}
                        TEST_ACTIVITY -> mWireFrame.goToTestActivity()
                    }
                    removeDrawerListener(this)
                }

                override fun onDrawerOpened(drawerView: View) {
                }
            })
        }
    }

    private fun initDrawerStrings(res: Int) {
        if (isCreated()) {
            val textItems : Array<String> = resources.getStringArray(res)
            val drawableItems : TypedArray = resources.obtainTypedArray(R.array.drawable_menu_items)
            val menuAdapter = MenuAdapter(this@MainActivity, Array(textItems.size, { i -> MenuItem(textItems[i], drawableItems.getResourceId(0, R.drawable.default_menu_item))}))
            drawableItems.recycle()
            leftDrawer.adapter = menuAdapter
        }
    }

    private fun closeDrawer() {
        if (isCreated()) {
            drawerLayout.closeDrawer(Gravity.START)
        }
    }

    private fun isDrawerOpen() : Boolean {
        if (isCreated()) {
            return drawerLayout.isDrawerOpen(Gravity.START)
        }
        return false
    }

    private fun addDrawerListener(listener : DrawerLayout.DrawerListener) {
        if (isCreated()) {
            drawerLayout.addDrawerListener(listener)
        }
    }

    private fun superOnBackPressed() {
        if (isCreated()) {
            super.onBackPressed()
        }
    }

    // ---- END Private ----

    // ---- Pubic ----

    fun removeDrawerListener(listener : DrawerLayout.DrawerListener) {
        if (isCreated()) {
            drawerLayout.removeDrawerListener(listener)
        }
    }

    // ---- END Public ----

}