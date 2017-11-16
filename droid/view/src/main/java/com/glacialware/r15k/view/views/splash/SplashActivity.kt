package com.glacialware.r15k.view.views.splash

import android.os.Bundle
import com.glacialware.r15k.view.presenters.splash.SplashPresenter
import com.glacialware.r15k.view.presenters.splash.SplashPreseterImpl
import com.glacialware.r15k.view.views.generic.GenericRootActivity

/**
 * Created by Guille on 30/06/2017.
 */
class SplashActivity : GenericRootActivity(), SplashView {
    private lateinit var presenter : SplashPresenter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = SplashPreseterImpl(this)

        presenter.endOnCreate()
    }




    override fun finishView() {
        if (isCreated()) {
            finish()
        }
    }
}