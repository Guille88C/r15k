package com.r15k.glacialware.r15k.presenters.splash

import android.app.Activity
import com.r15k.glacialware.r15k.views.splash.SplashView
import com.r15k.glacialware.r15k.wireframes.splash.SplashWireframe
import com.r15k.glacialware.r15k.wireframes.splash.SplashWireframeImpl

/**
 * Created by maric on 11/08/2017.
 */
class SplashPreseterImpl (private val view : SplashView) : SplashPresenter {
    private val wireframe : SplashWireframe = SplashWireframeImpl(view as Activity?)




    override fun endOnCreate() {
        wireframe.goToMain()
        view.finishView()
    }
}