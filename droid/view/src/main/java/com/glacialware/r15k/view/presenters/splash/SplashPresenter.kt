package com.glacialware.r15k.view.presenters.splash

import android.app.Activity
import com.glacialware.r15k.view.views.splash.SplashActivity
import com.glacialware.r15k.view.wireframes.splash.SplashWireframe

/**
* Created by maric on 11/08/2017.
*/
class SplashPresenter(private val view : SplashActivity) {
    private val wireframe : SplashWireframe = SplashWireframe(view as Activity?)

    fun endOnCreate() {
        wireframe.goToMain()
        view.finishView()
    }
}