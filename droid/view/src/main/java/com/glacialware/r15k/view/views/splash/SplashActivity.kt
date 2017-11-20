package com.glacialware.r15k.view.views.splash

import android.os.Bundle
import com.glacialware.r15k.view.presenters.splash.SplashPresenter
import com.glacialware.r15k.view.presenters.splash.SplashPreseterImpl
import com.glacialware.r15k.view.views.generic.GenericRootActivity

/**
 * Created by Guille on 30/06/2017.
 */
class SplashActivity : GenericRootActivity(), SplashView {
    private val presenter : SplashPresenter = SplashPreseterImpl(this)

    override fun initFragment() {
    }

    override fun initViewModel() {
    }

    override fun initView() {
        presenter.endOnCreate()
    }

    override fun finishView() {
        if (isCreated()) {
            finish()
        }
    }
}