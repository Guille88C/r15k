package com.r15k.glacialware.r15k.presenters.main

/**
 * Created by Tanuki on 17/07/2017.
 */
interface MainPresenter {
    fun initPresenter()

    fun onBackPressed()
    fun onClick()
    fun onItemClick(pos : Int)
}