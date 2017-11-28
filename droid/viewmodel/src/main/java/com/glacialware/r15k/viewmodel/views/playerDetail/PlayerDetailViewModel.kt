package com.glacialware.r15k.viewmodel.views.playerDetail

import android.app.Application
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.views.GenericDatabaseViewModel
import org.jetbrains.anko.doAsync

/**
 * Created by Guille on 17/11/2017.
 */
class PlayerDetailViewModel(app: Application) : GenericDatabaseViewModel(app) {
    var player: Player? = null
    var playerDetailView: IPlayerDetailView? = null

    fun deletePlayer() {
        doAsync {
            if (player != null) {
                database.playerDao().delete(player!!)

                if (playerDetailView != null) {
                    playerDetailView?.finishDeletePlayer()
                }
            }
        }
    }
}