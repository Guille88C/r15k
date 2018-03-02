package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter
import com.glacialware.r15k.view.views.di.GenericFragmentComponent
import com.glacialware.r15k.view.views.di.GenericFragmentModule

/**
* Created by Guille on 09/07/2017.
*/
abstract class GenericRootFragment: Fragment()  {

    // ---- Attributes ----

    protected var presenter: GenericFragmentPresenter? = null
    var mComponent: GenericFragmentComponent? = null

    // ---- END Attributes ----

    // ---- Fragment ----

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initDI()
        initPresenter()
        if (presenter != null && container != null) {
            return presenter?.initViewModel(inflater, container)
        }

        return null
    }

    // ---- END Fragment ----

    // ---- Private ----

    private fun initDI() {
        mComponent = (activity as GenericRootActivity?)?.mComponent?.with(GenericFragmentModule(context))
        mComponent?.inject(this)
    }

    // ---- END Private ----

    // ---- Abstract ----

    abstract fun initPresenter()

    // ---- END Abstract ----
}