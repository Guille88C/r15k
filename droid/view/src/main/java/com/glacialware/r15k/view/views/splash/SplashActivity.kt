package com.glacialware.r15k.view.views.splash

import com.glacialware.r15k.view.presenters.splash.SplashPresenter
import com.glacialware.r15k.view.views.generic.GenericRootActivity

/**
* Created by Guille on 30/06/2017.
*/
class SplashActivity : GenericRootActivity() {

    // ---- Attributes ----

    private val presenter = SplashPresenter(this)

    // ---- END Attributes ----

    // ---- Fragment ----

    override fun initFragment() {
    }

    override fun initViewModel() {
    }

    override fun initView() {
        presenter.endOnCreate()
    }

    // ---- END Fragment ----

    // ---- Public ----

    fun finishView() {
        if (isCreated()) {
            finish()
        }
    }

    // ---- END Public ----

}