package com.r15k.glacialware.r15k.presenters.main

import android.support.v4.widget.DrawerLayout
import android.view.View
import com.r15k.glacialware.r15k.views.main.MainActivity
import com.r15k.glacialware.r15k.views.main.MainView
import com.r15k.glacialware.r15k.wireframes.main.MainWireframe
import com.r15k.glacialware.r15k.wireframes.main.MainWireframeImpl

/**
 * Created by Guille on 09/07/2017.
 */
class MainPresenterImpl(private val view : MainView) : MainPresenter {
    companion object {
        private const val ADD_PLAYER : Int = 0
        private const val EDIT_CARD : Int = 1
        private const val START_GAME : Int = 2
    }




    private val wireframe : MainWireframe? = MainWireframeImpl(view as? MainActivity)




    override fun onBackPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer()
        } else {
            view.superOnBackPressed()
        }
    }

    override fun onClick() {
        wireframe?.goToTest()
    }

    override fun onItemClick(pos : Int) {
        view.closeDrawer()
        view.addDrawerListener(object : DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View?) {
                when (pos) {
                    ADD_PLAYER -> wireframe?.goToAddPlayer()
                    EDIT_CARD -> wireframe?.goToEditCard()
                    START_GAME -> {}
                }
                view.removeDrawerListener(this)
            }

            override fun onDrawerOpened(drawerView: View?) {
            }
        })
    }

}