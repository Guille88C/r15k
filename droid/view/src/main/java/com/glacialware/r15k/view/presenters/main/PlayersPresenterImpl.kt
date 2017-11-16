package com.glacialware.r15k.view.presenters.main

import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.view.views.main.PlayersFragment
import com.glacialware.r15k.view.wireframes.main.PlayersWireframe
import com.glacialware.r15k.view.wireframes.main.PlayersWireframeImpl

/**
 * Created by Guille on 16/11/2017.
 */
class PlayersPresenterImpl(private val view : PlayersFragment) : PlayersPresenter {

    private val wireframe : PlayersWireframe = PlayersWireframeImpl(view)

    override fun onItemPlayerClick(player: Player) {
        wireframe?.goToPlayerDetail()
    }
}