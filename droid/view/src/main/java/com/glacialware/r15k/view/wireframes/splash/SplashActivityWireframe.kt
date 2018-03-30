package com.glacialware.r15k.view.wireframes.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.views.main.MainActivity
import com.glacialware.r15k.view.views.splash.SplashActivity

/**
* Created by maric on 11/08/2017.
*/
class SplashActivityWireframe(private val mActivity: AppCompatActivity) {

    // ---- Public ----

    fun goToMain() {
        val intent = Intent(mActivity, MainActivity ::class.java)
        mActivity.startActivity(intent)
    }

    // ---- END Public ----

}