package com.glacialware.r15k.view.wireframes.playerDetail

import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailFragment
import com.glacialware.r15k.view.wireframes.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateTo

/**
* Created by Guille on 17/11/2017.
*/
class PlayerDetailActivityWireframe(private val view: PlayerDetailActivity) : GenericActivityWireframe() {
    override fun initFragment() {
        navigateTo(view.supportFragmentManager, PlayerDetailFragment.newInstance(), PlayerDetailFragment.TAG, R.id.frame_content, true, false)
    }
}