package com.r15k.glacialware.r15k.views.splash

import android.os.Bundle
import com.r15k.glacialware.r15k.rooting.navigateTo
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import com.r15k.glacialware.r15k.views.main.MainActivity

/**
 * Created by Guille on 30/06/2017.
 */
class SplashActivity : GenericRootActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflateLayout() {

    }

    override fun init() {
        navigateTo(this, MainActivity :: class.java)
        this.finish()
    }
}