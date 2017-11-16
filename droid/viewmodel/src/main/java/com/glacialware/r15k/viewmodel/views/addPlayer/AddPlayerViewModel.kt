package com.glacialware.r15k.viewmodel.views.addPlayer

import android.app.Application
import android.databinding.ObservableField
import android.view.View
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.views.GeneralDatabaseViewModel
import org.jetbrains.anko.doAsync

/**
 * Created by Guille on 15/11/2017.
 */
class AddPlayerViewModel(app : Application) : GeneralDatabaseViewModel(app) {

    val namePlayer : ObservableField<String> = ObservableField("")

    fun onAddPlayerClick(view : View) {
        doAsync {
            database.playerDao().insert(Player(namePlayer.get(), false))
        }
    }
}