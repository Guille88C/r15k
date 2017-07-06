package com.r15k.glacialware.r15k.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Guille on 04/07/2017.
 */
open abstract class GenericRootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.inflateLayout()
        this.init()
    }

    protected abstract fun inflateLayout()
    protected abstract fun init()
}