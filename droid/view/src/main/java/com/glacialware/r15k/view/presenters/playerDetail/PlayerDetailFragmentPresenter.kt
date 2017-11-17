package com.glacialware.r15k.view.presenters.playerDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Guille on 17/11/2017.
 */
interface PlayerDetailFragmentPresenter {
    fun initViewModel(inflater: LayoutInflater, container: ViewGroup) : View?
}