package com.glacialware.r15k.viewmodel.views.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.model.room.Mission
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.model.room.PlayerMission
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseComponent
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.model.di.DaggerAppDatabaseComponent
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersViewModel(app: Application) : AndroidViewModel(app) {
    @field:[Inject]
    lateinit var database: AppDatabase

    private val databaseComponent: AppDatabaseComponent by lazy {
        DaggerAppDatabaseComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }

    fun init() {
        databaseComponent.inject(this)

        doAsync {

//            database.createFakeData()
            database.clearAllTables()
            val listPlayers = database.playerDao().getAll()

            uiThread {
                test(listPlayers)
            }
        }
    }

    fun test(listPlayers: List<Player>) {
        lPlayers.value = listPlayers
    }

    val lPlayers : MutableLiveData<List<Player>> = MutableLiveData()
}