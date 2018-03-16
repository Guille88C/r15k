package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.wireframes.PLAYER
import com.glacialware.r15k.view.wireframes.generic.GenericFragmentWireframe

/**
* Created by Guille on 16/11/2017.
*/
class PlayersFragmentWireframe(view : PlayersFragment) : GenericFragmentWireframe(view) {

    // ---- Public ----

    fun goToPlayerDetail(player: Player) {
        val intent = Intent(mFragment.activity, PlayerDetailActivity :: class.java)
//        intent.putExtra(PLAYER, player)
        mFragment.startActivity(intent)
    }

    // ---- END Public ----
}