package com.r15k.glacialware.r15k.views

import android.os.Bundle
import com.r15k.glacialware.r15k.R
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity

/**
 * Created by Guille on 06/07/2017.
 */
class TestActivity : GenericRootActivity(true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflateLayout() {
        this.setContentView(R.layout.activity_test)
    }

    override fun init() {

    }
}