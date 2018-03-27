package com.glacialware.r15k.model.room.managers

import android.content.Context
import com.glacialware.r15k.model.room.Player

class ManagerPlayerDatabase(context: Context): ManagerBaseDatabase(context) {
    // ---- Public ----
    fun getAllPlayers(): List<Player> {
        return mDatabase.playerDao().getAll()
    }

    fun clearPlayers() {
        mDatabase.playerDao().clear()
    }

    fun insertPlayer(player: Player) {
        mDatabase.playerDao().insert(player)
    }

    fun deletePlayer(player: Player) {
        mDatabase.playerDao().delete(player)
    }
    // ---- END Public ----
}