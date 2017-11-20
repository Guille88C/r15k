package com.glacialware.r15k.view.presenters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Guille on 20/11/2017.
 */
abstract class GenericFragmentPresenter {
    abstract fun initViewModel(inflater: LayoutInflater, container: ViewGroup) : View?
}