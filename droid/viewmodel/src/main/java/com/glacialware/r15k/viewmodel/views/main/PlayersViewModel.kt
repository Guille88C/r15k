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
            val mission1 = Mission(0, "mission title 1", "mission desc 1", "image 1", false)
            val mission2 = Mission(1, "mission title 2", "mission desc 2", "image 2", false)
            database.missionDao().insert(mission1)
            database.missionDao().insert(mission2)

            val playerRoom1 = Player(0, "player 1", false)
            val playerRoom2 = Player(1, "player 2", false)
            database.playerDao().insert(playerRoom1)
            database.playerDao().insert(playerRoom2)

            val playerMission1 = PlayerMission(0, 1)
            val playerMission2 = PlayerMission(1, 0)
            database.playerMissionDao().insert(playerMission1)
            database.playerMissionDao().insert(playerMission2)

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