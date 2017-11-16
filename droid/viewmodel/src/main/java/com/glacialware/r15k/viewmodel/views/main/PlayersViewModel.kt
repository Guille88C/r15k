package com.glacialware.r15k.viewmodel.views.main

import android.app.Application
import android.arch.lifecycle.*
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.views.GeneralDatabaseViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersViewModel(app : Application) : GeneralDatabaseViewModel(app) {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun checkPlayers() {
        doAsync {
            val listPlayers = database.playerDao().getAll()

            uiThread {
                lPlayers.value = listPlayers
            }
        }
    }

    val lPlayers : MutableLiveData<List<Player>> = MutableLiveData()
}