package com.r15k.glacialware.r15k.views.splash

import android.os.Bundle
import com.r15k.glacialware.r15k.presenters.splash.SplashPresenter
import com.r15k.glacialware.r15k.presenters.splash.SplashPreseterImpl
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity

/**
 * Created by Guille on 30/06/2017.
 */
class SplashActivity : GenericRootActivity(), SplashView {
    lateinit var presenter : SplashPresenter




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