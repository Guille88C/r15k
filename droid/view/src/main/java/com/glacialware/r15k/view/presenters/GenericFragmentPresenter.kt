package com.glacialware.r15k.view.presenters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.components.CustomToast
import com.glacialware.r15k.view.presenters.di.GenericFragmentPresenterComponent
import com.glacialware.r15k.view.presenters.di.GenericFragmentPresenterModule
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import javax.inject.Inject

/**
* Created by Guille on 20/11/2017.
*/
abstract class GenericFragmentPresenter(protected val mView: GenericRootFragment) {

    // ---- Dagger ----

    @field:[Inject]
    lateinit var mCustomToast : CustomToast

    // ---- END Dagger ----

    // ---- Attributes ----

    private var mComponent: GenericFragmentPresenterComponent? = null

    // ---- END Attributes ----

    // ---- Builder ----

    init {
        initDI()
    }

    // ---- END Builder ----

    // ---- Abstract ----

    abstract fun initViewModel(inflater: LayoutInflater, container: ViewGroup) : View?

    // ---- END Abstract ----

    // ---- Protected ----

    private fun initDI() {
        mComponent = mView.mComponent?.with(GenericFragmentPresenterModule(mView.activity))
        mComponent?.inject(this)
    }

    // ---- END Protected ----
}