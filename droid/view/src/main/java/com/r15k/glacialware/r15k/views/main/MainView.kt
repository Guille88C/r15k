package com.r15k.glacialware.r15k.views.main

import android.support.v4.widget.DrawerLayout

/**
 * Created by Tanuki on 17/07/2017.
 */
interface MainView {
    fun initDrawerStrings(res : Int)
    fun closeDrawer()
    fun isDrawerOpen() : Boolean
    fun addDrawerListener(listener : DrawerLayout.DrawerListener)
    fun removeDrawerListener(listener : DrawerLayout.DrawerListener)

    fun superOnBackPressed()
}