package com.glacialware.r15k.model.room.managers

import android.content.Context
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.model.room.Player

class ManagerPlayerDatabase(private val mContext: Context) {
    // ---- Public ----
    fun getAllPlayers(): List<Player> {
        return AppDatabase.newInstance(mContext).playerDao().getAll()
    }

    fun clearPlayers() {
        AppDatabase.newInstance(mContext).playerDao().clear()
    }

    fun insertPlayer(player: Player) {
        AppDatabase.newInstance(mContext).playerDao().insert(player)
    }

    fun deletePlayer(player: Player) {
        AppDatabase.newInstance(mContext).playerDao().delete(player)
    }
    // ---- END Public ----
}