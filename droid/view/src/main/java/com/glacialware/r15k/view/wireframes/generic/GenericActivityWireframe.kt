package com.glacialware.r15k.view.wireframes.generic

import com.glacialware.r15k.view.views.generic.GenericRootActivity

/**
* Created by Guille on 20/11/2017.
*/
abstract class GenericActivityWireframe(protected val mActivity: GenericRootActivity) {
    abstract fun initFragment()
}