package com.glacialware.r15k.viewmodel.views

import android.app.Application
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import com.glacialware.r15k.viewmodel.di.AppDatabaseComponent
import com.glacialware.r15k.viewmodel.di.AppDatabaseModule
import com.glacialware.r15k.viewmodel.di.DaggerAppDatabaseComponent
import com.glacialware.r15k.viewmodel.views.generic.GenericViewModel
import javax.inject.Inject

/**
* Created by Guille on 16/11/2017.
*/
abstract class GenericDatabaseViewModel(app: Application) : GenericViewModel(app) {
    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mDatabasePlayerManager: ManagerPlayerDatabase

    private val serviceComponent: AppDatabaseComponent by lazy {
        DaggerAppDatabaseComponent
                .builder()
                .appDatabaseModule(AppDatabaseModule(getApplication<Application>().applicationContext))
                .build()
    }
    // ---- END Dagger attributes ----

    // ---- Builder ----
    init {
        initDaggerComponent()
    }
    // ---- END Builder ----

    // ---- Private ----
    private fun initDaggerComponent() {
        serviceComponent.inject(this)
    }
    // ---- END Private ----
}