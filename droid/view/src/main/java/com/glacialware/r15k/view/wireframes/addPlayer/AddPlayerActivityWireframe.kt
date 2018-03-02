package com.glacialware.r15k.view.wireframes.addPlayer

import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateTo

/**
* Created by Guille on 20/11/2017.
*/
class AddPlayerActivityWireframe(view: AddPlayerActivity) : GenericActivityWireframe(view) {

    // ---- ActivityWireframe ----

    override fun initFragment() {
        navigateTo(mActivity.supportFragmentManager, AddPlayerFragment.newInstance(), AddPlayerFragment.TAG, R.id.frame_content, true, false)
    }

    // ---- END ActivityWireframe ----

}