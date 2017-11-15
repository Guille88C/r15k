package com.glacialware.r15k.viewmodel.views.main

import android.app.Application
import android.arch.lifecycle.*
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.model.room.Player
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseComponent
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.model.di.DaggerAppDatabaseComponent
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

/**
 * Created by Guille on 13/11/2017.
 */
class PlayersViewModel : AndroidViewModel, LifecycleObserver {
    @field:[Inject]
    lateinit var database: AppDatabase

    private val databaseComponent: AppDatabaseComponent by lazy {
        DaggerAppDatabaseComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }

    constructor(app: Application) : super(app){
        databaseComponent.inject(this)
    }

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