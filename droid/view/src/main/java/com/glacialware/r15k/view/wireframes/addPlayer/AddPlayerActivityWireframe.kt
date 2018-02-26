package com.glacialware.r15k.view.wireframes.addPlayer

import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.view.wireframes.GenericActivityWireframe
import com.glacialware.r15k.view.wireframes.navigateTo

/**
* Created by Guille on 20/11/2017.
*/
class AddPlayerActivityWireframe(private val view: AddPlayerActivity) : GenericActivityWireframe() {
    override fun initFragment() {
        navigateTo(view.supportFragmentManager, AddPlayerFragment.newInstance(), AddPlayerFragment.TAG, R.id.frame_content, true, false)
    }
}