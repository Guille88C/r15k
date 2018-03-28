package com.glacialware.r15k.viewmodel.views.main

import android.app.Application
import android.arch.lifecycle.*
import com.glacialware.r15k.viewmodel.model.Player
import com.glacialware.r15k.viewmodel.views.generic.GenericDatabaseViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.util.ArrayList

/**
* Created by Guille on 13/11/2017.
*/
class MainViewModel(app : Application) : GenericDatabaseViewModel(app) {
    // ---- Attributes ----

    private var shouldFetch = true
    private var mPlayersView: PlayersView? = null

    // ---- END Attributes ----

    // ---- Properties ----

    val lPlayers : MutableLiveData<MutableList<Player>> = MutableLiveData()

    // ---- END Properties ----

    // ---- Lifecycle ----

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun checkPlayers() {
        doAsync {
            // Observe disk && dispatch value.
            val lItems = mDatabasePlayerManager.getAllPlayers()
            uiThread {
                lPlayers.value?.clear()
                val list = ArrayList<Player>()
                lItems.forEach { roomPlayer ->
                    val player = Player()
                    player.fromRoom(roomPlayer)
                    list.add(player)
                }

                if (lPlayers.value == null) {
                    lPlayers.value = list
                }
                else {
                    lPlayers.postValue(list)
                }
            }
        }
    }

    // ---- END Lifecycle ----

    // ---- Public ----

    fun setPlayersView(view: PlayersView) {
        mPlayersView = view
    }

    // ---- END Public ----

    // ---- Events ----

    fun onPlayerClick(player: Player) {
        mPlayersView?.showPlayerDetail(player)
    }

    // ---- END Events ----
}