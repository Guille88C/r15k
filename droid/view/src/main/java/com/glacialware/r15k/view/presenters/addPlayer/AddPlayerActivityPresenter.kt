package com.glacialware.r15k.view.presenters.addPlayer

import com.glacialware.r15k.view.presenters.GenericActivityPresenter
import com.glacialware.r15k.view.views.addPlayer.AddPlayerActivity
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerActivityWireframe

/**
* Created by Guille on 20/11/2017.
*/
class AddPlayerActivityPresenter(view: AddPlayerActivity) : GenericActivityPresenter() {

    // ---- Attributes ----

    private val wireframe = AddPlayerActivityWireframe(view)

    // ---- END Attributes ----

    // ---- ActivityPresenter ----

    override fun initViewModel() {
    }

    override fun initFragment() {
        wireframe.initFragment()
    }

    // ---- END ActivityPresenter ----

}