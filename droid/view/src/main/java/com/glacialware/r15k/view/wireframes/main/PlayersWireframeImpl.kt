package com.glacialware.r15k.view.wireframes.main

import android.content.Intent
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.views.playerDetail.PlayerDetailActivity

/**
 * Created by Guille on 16/11/2017.
 */
class PlayersWireframeImpl(private val fragment : PlayersFragment) : PlayersWireframe {
    override fun goToPlayerDetail() {
        val intent = Intent(fragment.activity, PlayerDetailActivity :: class.java)
        fragment.startActivity(intent)
    }
}