package com.r15k.glacialware.r15k.presenter.main

import com.r15k.glacialware.r15k.views.main.MainActivity
import com.r15k.glacialware.r15k.views.main.MenuItem

/**
 * Created by Guille on 09/07/2017.
 */
class MainPresenter(private val activity : MainActivity) {
    enum class MenuOption {
        NONE,
        ADD_PLAYER,
        START_GAME
    }

    fun getMenuData() : ArrayList<MenuItem> {
        return mutableListOf(
                MenuItem("__add player"),
                MenuItem("__start game")) as ArrayList<MenuItem>
    }

    fun getMenuOption(pos : Int) : MenuOption {
        if (pos == 0) return MenuOption.ADD_PLAYER
        else if (pos == 1) return MenuOption.START_GAME
        else return MenuOption.NONE
    }
}