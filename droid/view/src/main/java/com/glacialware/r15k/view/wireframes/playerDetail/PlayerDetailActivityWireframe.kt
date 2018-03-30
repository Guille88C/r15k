package com.glacialware.r15k.view.wireframes.playerDetail

import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailFragment
import com.glacialware.r15k.view.wireframes.generic.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateTo

/**
* Created by Guille on 17/11/2017.
*/
class PlayerDetailActivityWireframe(view: AppCompatActivity) : GenericActivityWireframe(view) {

    // ---- ActivityWireframe ----

    override fun initFragment() {
        navigateTo(mActivity.supportFragmentManager, PlayerDetailFragment.newInstance(), PlayerDetailFragment.TAG, R.id.frame_content, true, false)
    }

    // ---- END ActivityWireframe ----

}