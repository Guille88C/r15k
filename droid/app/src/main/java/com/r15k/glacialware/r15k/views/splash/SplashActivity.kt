package com.r15k.glacialware.r15k.views.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.views.main.MainActivity

/**
 * Created by Guille on 30/06/2017.
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var intent = Intent(this, MainActivity :: class.java)
        this.startActivity(intent)
    }
}