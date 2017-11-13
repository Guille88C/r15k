package com.glacialware.r15k.view.views

import android.os.Bundle
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.generic.GenericRootActivity

/**
 * Created by Guille on 06/07/2017.
 */
class TestActivity : GenericRootActivity(true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_test)
    }
}