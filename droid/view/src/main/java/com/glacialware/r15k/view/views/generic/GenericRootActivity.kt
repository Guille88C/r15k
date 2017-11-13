package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.navigateBackAnimated

/**
 * Created by Guille on 04/07/2017.
 */
abstract class GenericRootActivity constructor(private var anim: Boolean = false) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (anim && this.supportFragmentManager.backStackEntryCount == 0) {
            navigateBackAnimated(this)
        }
    }




    fun isCreated() : Boolean {
        return !isFinishing && !isDestroyed
    }
}