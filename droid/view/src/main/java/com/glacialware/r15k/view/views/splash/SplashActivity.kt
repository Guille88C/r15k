package com.glacialware.r15k.view.views.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.RiskApplication
import com.glacialware.r15k.view.views.di.ActivityModule
import com.glacialware.r15k.view.wireframes.splash.SplashActivityWireframe
import javax.inject.Inject

/**
* Created by Guille on 30/06/2017.
*/
class SplashActivity : AppCompatActivity() {

    // ---- Dagger attributes ----
    @field:[Inject]
    lateinit var mWireframe: SplashActivityWireframe
    // ---- END Dagger attributes ----

    // ---- Activity ----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as RiskApplication).applicationComponent.with(ActivityModule(this)).inject(this)

        mWireframe.goToMain()
        finish()
    }

    // ---- END Activity ----

}