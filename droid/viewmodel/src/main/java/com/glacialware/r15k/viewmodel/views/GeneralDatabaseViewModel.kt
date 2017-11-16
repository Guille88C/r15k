package com.glacialware.r15k.viewmodel.views

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseComponent
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.model.di.DaggerAppDatabaseComponent
import javax.inject.Inject

/**
 * Created by Guille on 16/11/2017.
 */
abstract class GeneralDatabaseViewModel : AndroidViewModel, LifecycleObserver {
    @field:[Inject]
    protected lateinit var database: AppDatabase

    private val databaseComponent: AppDatabaseComponent by lazy {
        DaggerAppDatabaseComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }

    constructor(app: Application) : super(app){
        databaseComponent.inject(this)
    }
}