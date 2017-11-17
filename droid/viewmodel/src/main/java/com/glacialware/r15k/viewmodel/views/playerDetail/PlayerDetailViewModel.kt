package com.glacialware.r15k.viewmodel.views.playerDetail

import android.app.Application
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.views.GeneralDatabaseViewModel

/**
 * Created by Guille on 17/11/2017.
 */
class PlayerDetailViewModel(app: Application) : GeneralDatabaseViewModel(app) {
    var player: Player? = null
}