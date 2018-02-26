package com.glacialware.r15k.viewmodel.views

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LifecycleObserver
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.model.di.DaggerGeneralComponent
import com.glacialware.r15k.viewmodel.model.di.GeneralComponent
import javax.inject.Inject

/**
* Created by Guille on 16/11/2017.
*/
abstract class GenericDatabaseViewModel : AndroidViewModel, LifecycleObserver {
    @field:[Inject]
    protected lateinit var database: AppDatabase

    private val serviceComponent: GeneralComponent by lazy {
        DaggerGeneralComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }

    constructor(app: Application) : super(app){
        serviceComponent.inject(this)
    }
}