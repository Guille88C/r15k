package com.r15k.glacialware.r15k.views.generic

import android.os.Bundle
import com.r15k.glacialware.r15k.R

/**
 * Created by Guille on 04/07/2017.
 */
open abstract class GenericRootTransitionActivity : GenericRootActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        this.overridePendingTransition(R.anim.slide_in_exit, R.anim.slide_out_exit)
    }
}