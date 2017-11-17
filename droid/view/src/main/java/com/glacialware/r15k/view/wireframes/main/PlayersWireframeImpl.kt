package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity
import com.glacialware.r15k.view.wireframes.PLAYER

/**
 * Created by Guille on 16/11/2017.
 */
class PlayersWireframeImpl(private val fragment : PlayersFragment) : PlayersWireframe {
    override fun goToPlayerDetail(player: Player) {
        val intent = Intent(fragment.activity, PlayerDetailActivity :: class.java)
        intent.putExtra(PLAYER, player)
        fragment.startActivity(intent)
    }
}