package com.glacialware.r15k.view.wireframes.splash

import android.app.Activity
import android.content.Intent
import com.glacialware.r15k.view.views.TestActivity
import com.glacialware.r15k.view.views.main.MainActivity

/**
 * Created by maric on 11/08/2017.
 */
class SplashWireframeImpl(private val activity : Activity?) : SplashWireframe {
    override fun goToMain() {
//        val intent = Intent(activity, MainActivity ::class.java)
        val intent = Intent(activity, TestActivity::class.java)
        activity?.startActivity(intent)
    }
}