package com.glacialware.r15k.view.wireframes.splash

import android.content.Intent
import com.glacialware.r15k.view.views.main.MainActivity
import com.glacialware.r15k.view.views.splash.SplashActivity
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe

/**
* Created by maric on 11/08/2017.
*/
class SplashActivityWireframe(view: SplashActivity) : GenericActivityWireframe(view) {

    // ---- Public ----

    override fun initFragment() {
        // Nothing.
    }

    fun goToMain() {
        val intent = Intent(mActivity, MainActivity ::class.java)
        mActivity.startActivity(intent)
    }

    // ---- END Public ----

}