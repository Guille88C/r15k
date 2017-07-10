package com.r15k.glacialware.r15k.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.rooting.navigateBackAnimated

/**
 * Created by Guille on 04/07/2017.
 */
abstract class GenericRootActivity constructor(private var anim: Boolean = false) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }

        this.inflateLayout()
        this.init()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (anim && this.supportFragmentManager.backStackEntryCount == 0) {
            navigateBackAnimated(this)
        }
    }

    protected abstract fun inflateLayout()
    protected abstract fun init()
}