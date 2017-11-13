package com.glacialware.r15k.view.presenters.splash

import android.app.Activity
import com.glacialware.r15k.view.views.splash.SplashView
import com.glacialware.r15k.view.wireframes.splash.SplashWireframe
import com.glacialware.r15k.view.wireframes.splash.SplashWireframeImpl

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