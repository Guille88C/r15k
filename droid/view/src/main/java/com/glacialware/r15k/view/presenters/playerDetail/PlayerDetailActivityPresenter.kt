package com.glacialware.r15k.view.presenters.playerDetail

import android.arch.lifecycle.ViewModelProviders
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.presenters.GenericActivityPresenter
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.wireframes.PLAYER
import com.glacialware.r15k.view.wireframes.playerDetail.PlayerDetailActivityWireframe
import com.glacialware.r15k.viewmodel.views.playerDetail.PlayerDetailViewModel

/**
* Created by Guille on 17/11/2017.
*/
class PlayerDetailActivityPresenter : GenericActivityPresenter() {

    // ---- Attributes ----

//    private val wireframe: PlayerDetailActivityWireframe = PlayerDetailActivityWireframe(view)
//    private var viewModel : PlayerDetailViewModel? = null

    // ---- END Attributes ----

    // ---- ActivityPresenter ----

//    override fun initViewModel() {
//        this.viewModel = ViewModelProviders.of(view).get(PlayerDetailViewModel::class.java)
//        if (this.viewModel != null && view.intent.getSerializableExtra(PLAYER) is Player) {
//            val player = view.intent.getSerializableExtra(PLAYER) as Player
//            this.viewModel?.player = player
//        }
//    }

//    override fun initFragment() {
//        wireframe.initFragment()
//    }

    // ---- END ActivityPresenter ----

}