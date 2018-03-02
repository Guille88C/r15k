package com.glacialware.r15k.view.presenters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.views.generic.GenericRootFragment

/**
* Created by Guille on 20/11/2017.
*/
abstract class GenericFragmentPresenter(protected val mView: GenericRootFragment) {

    // ---- Abstract ----

    abstract fun initViewModel(inflater: LayoutInflater, container: ViewGroup) : View?

    // ---- END Abstract ----
}