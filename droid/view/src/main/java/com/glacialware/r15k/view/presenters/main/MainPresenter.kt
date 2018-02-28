package com.glacialware.r15k.view.presenters.main

import android.support.v4.widget.DrawerLayout
import android.view.View
import com.glacialware.r15k.view.presenters.GenericActivityPresenter
import com.glacialware.r15k.view.views.main.MainActivity
import com.glacialware.r15k.view.wireframes.main.MainWireframe

/**
* Created by Guille on 09/07/2017.
*/
class MainPresenter(private val view : MainActivity) : GenericActivityPresenter() {

    // ---- Companion ----

    companion object {
        private const val ADD_PLAYER = 0
        private const val EDIT_CARD = 1
        private const val START_GAME = 2
        private const val TEST_ACTIVITY = 3
    }

    // ---- END Companion ----

    // ---- Attributes ----

    private val wireframe : MainWireframe? = MainWireframe(view as? MainActivity)

    // ---- END Attributes ----

    // ---- ActivityPresenter ----

    override fun initViewModel() {
    }

    override fun initFragment() {
        wireframe?.startFragment()
    }

    // ---- END ActivityPresenter ----

    // ---- Public ----

    fun onBackPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer()
        } else {
            view.superOnBackPressed()
        }
    }

    fun onItemClick(pos : Int) {
        view.closeDrawer()
        view.addDrawerListener(object: DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View) {
                when (pos) {
                    ADD_PLAYER -> wireframe?.goToAddPlayer()
                    EDIT_CARD -> wireframe?.goToEditCard()
                    START_GAME -> {}
                    TEST_ACTIVITY -> wireframe?.goToTestActivity()
                }
                view.removeDrawerListener(this)
            }

            override fun onDrawerOpened(drawerView: View) {
            }
        })
    }

    // ---- END Public ----
}