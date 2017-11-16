package com.glacialware.r15k.viewmodel.views.addPlayer

import android.app.Application
import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.Interfaces.ICustomToast
import com.glacialware.r15k.viewmodel.R
import com.glacialware.r15k.viewmodel.views.GeneralDatabaseViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Guille on 15/11/2017.
 */
class AddPlayerViewModel(app : Application) : GeneralDatabaseViewModel(app) {

    var iToast : ICustomToast? = null

    val namePlayer : ObservableField<String> = ObservableField("")

    fun setToast(component : ICustomToast) {
        this.iToast = component
    }

    fun onAddPlayerClick(view : View) {
        doAsync {
            database.playerDao().insert(Player(namePlayer.get(), false))
            uiThread {
                if (iToast != null) {
                    iToast?.startToast(getApplication<Application>().applicationContext.getString(R.string.add_player_toast_text, namePlayer.get()))
                }
                namePlayer.set("")
            }
        }
    }
}