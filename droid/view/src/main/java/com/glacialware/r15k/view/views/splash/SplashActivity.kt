package com.glacialware.r15k.view.views.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.wireframes.splash.SplashActivityWireframe

/**
* Created by Guille on 30/06/2017.
*/
class SplashActivity : AppCompatActivity() {

    // ---- Activity ----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val wireframe = SplashActivityWireframe(this)
        wireframe.goToMain()
        finish()
    }

    // ---- END Activity ----

}