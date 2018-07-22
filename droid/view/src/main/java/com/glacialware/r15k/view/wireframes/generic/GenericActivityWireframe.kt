package com.glacialware.r15k.view.wireframes.generic

import android.support.v7.app.AppCompatActivity

/**
* Created by Guille on 20/11/2017.
*/
abstract class GenericActivityWireframe(protected val mActivity: AppCompatActivity) {
    abstract fun initFragment()
}