package com.r15k.glacialware.r15k.presenter.main

import android.support.v4.widget.DrawerLayout
import android.view.View
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.TestActivity
import com.r15k.glacialware.r15k.views.addPlayer.AddPlayerActivity
import com.r15k.glacialware.r15k.views.main.MainActivity
import com.r15k.glacialware.r15k.views.main.MainView
import com.r15k.glacialware.r15k.views.main.MenuItem

/**
 * Created by Guille on 09/07/2017.
 */
class MainPresenterImpl(private val view : MainView) : MainPresenter {

    enum class MenuOption {
        NONE,
        ADD_PLAYER,
        START_GAME
    }




    private fun getMenuOption(pos : Int) : MenuOption {
        if (pos == 0) return MenuOption.ADD_PLAYER
        else if (pos == 1) return MenuOption.START_GAME
        else return MenuOption.NONE
    }




    override fun onBackPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer()
        } else {
            view.superOnBackPressed()
        }
    }

    override fun onClick() {
        view.navigateToTest()
    }

    override fun onItemClick(pos : Int) {
        view.closeDrawer()
        view.addDrawerListener(object : DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View?) {
                val menuOption : MainPresenterImpl.MenuOption = getMenuOption(pos)
                when (menuOption) {
                    MainPresenterImpl.MenuOption.ADD_PLAYER -> view.navigateToAddPlayer()
                    MainPresenterImpl.MenuOption.START_GAME -> {}
                    MainPresenterImpl.MenuOption.NONE -> {}
                }
                view.removeDrawerListener(this)
            }

            override fun onDrawerOpened(drawerView: View?) {
            }
        })
    }

}