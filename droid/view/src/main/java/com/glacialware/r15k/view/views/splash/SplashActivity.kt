package com.glacialware.r15k.view.views.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.views.di.ActivityDependency

/**
* Created by Guille on 30/06/2017.
*/
class SplashActivity : AppCompatActivity() {

    // ---- Attributes ----
    private val mWireframe = ActivityDependency.provideSplashWireframe(this)
    // ---- END Attributes ----

    // ---- Activity ----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mWireframe.goToMain()
        finish()
    }

    // ---- END Activity ----

}