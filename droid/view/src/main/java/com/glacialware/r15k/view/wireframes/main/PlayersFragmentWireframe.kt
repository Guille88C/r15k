package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import android.databinding.ViewDataBinding
import com.glacialware.r15k.view.views.generic.GenericRootFragment
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.wireframes.PLAYER
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe
import com.glacialware.r15k.viewmodel.model.Player
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel

@Suppress("UNCHECKED_CAST")
/**
* Created by Guille on 16/11/2017.
*/
class PlayersFragmentWireframe(view : PlayersFragment) : GenericFragmentWireframe(view as GenericRootFragment<GenericFragmentWireframe, GenericViewModel, ViewDataBinding>) {

    // ---- Public ----

    fun goToPlayerDetail(player: Player) {
        val intent = Intent(mFragment.activity, PlayerDetailActivity :: class.java)
        intent.putExtra(PLAYER, player)
        mFragment.startActivity(intent)
    }

    // ---- END Public ----
}