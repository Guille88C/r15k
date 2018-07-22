package com.glacialware.r15k.view.wireframes.addPlayer

import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.view.wireframes.Wireframe
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe

/**
* Created by Guille on 20/11/2017.
*/
class AddPlayerActivityWireframe(view: AppCompatActivity) : GenericActivityWireframe(view) {

    // ---- ActivityWireframe ----

    override fun initFragment() {
        Wireframe.navigateTo(mActivity.supportFragmentManager, AddPlayerFragment.newInstance(), AddPlayerFragment.TAG, R.id.frame_content, true, false)
    }

    // ---- END ActivityWireframe ----

}