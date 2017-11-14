package com.glacialware.r15k.viewmodel.views.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.glacialware.r15k.view.entities.Mission
import com.glacialware.r15k.view.entities.Player
import kotlin.collections.ArrayList

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersViewModel : ViewModel {
    constructor() {
        var listPlayers = ArrayList<Player>()

        var listMission = ArrayList<Mission>()
        val m = Mission(0, "mission title", "mission desc", "image", false, 0)
        listMission.add(m)

        // player 1
        val player1 = Player(0, "player 1", listMission, false)
        listPlayers.add(player1)
        // ----

        // player 2
        val player2 = Player(1, "player 2", listMission, false)
        listPlayers.add(player2)
        // ----

        val lPlayersAux = MutableLiveData<ArrayList<Player>>()
        lPlayersAux.value = listPlayers
        ListPlayers = lPlayersAux
    }

    lateinit var lPlayers : LiveData<ArrayList<Player>>

    var ListPlayers : LiveData<ArrayList<Player>>
    get() {
        return lPlayers
    }
    set(value) {
        lPlayers = value
    }
}