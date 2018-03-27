package com.glacialware.r15k.viewmodel.views

import android.app.Application
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseComponent
import com.glacialware.r15k.viewmodel.model.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.model.di.DaggerAppDatabaseComponent
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import javax.inject.Inject

/**
* Created by Guille on 16/11/2017.
*/
abstract class GenericDatabaseViewModel(app: Application) : GenericViewModel(app) {
    @field:[Inject]
    protected lateinit var mDatabasePlayerManager: ManagerPlayerDatabase

    private val serviceComponent: AppDatabaseComponent by lazy {
        DaggerAppDatabaseComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }

    init {
        serviceComponent.inject(this)
    }

}