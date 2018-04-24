package com.glacialware.r15k.viewmodel.views.generic

import android.app.Application
import com.glacialware.r15k.model.firebase.FirebaseMissionManager
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import com.glacialware.r15k.viewmodel.views.di.DaggerViewModelComponent
import com.glacialware.r15k.viewmodel.views.di.ViewModelComponent
import com.glacialware.r15k.viewmodel.views.di.ViewModelModule
import javax.inject.Inject

/**
* Created by Guille on 16/11/2017.
*/
abstract class GenericDatabaseViewModel(app: Application) : GenericViewModel(app) {
    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mDatabasePlayerManager: ManagerPlayerDatabase

    @Inject
    protected lateinit var mFirebaseMissionManager: FirebaseMissionManager

    private val mComponent: ViewModelComponent by lazy {
        DaggerViewModelComponent
                .builder()
                .viewModelModule(ViewModelModule(getApplication<Application>().applicationContext))
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
        mComponent.inject(this)
    }
    // ---- END Private ----
}