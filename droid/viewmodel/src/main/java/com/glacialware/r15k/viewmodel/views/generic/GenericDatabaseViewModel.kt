package com.glacialware.r15k.viewmodel.views.generic

import android.app.Application
import com.glacialware.r15k.model.firebase.FirebaseMissionManager
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import com.glacialware.r15k.viewmodel.views.di.ViewModelDependency

/**
* Created by Guille on 16/11/2017.
*/
abstract class GenericDatabaseViewModel(app: Application) : GenericViewModel(app) {
    protected val mDatabasePlayerManager: ManagerPlayerDatabase =
            ViewModelDependency.providePlayerDatabaseManager(app)
    protected val mFirebaseMissionManager: FirebaseMissionManager =
            ViewModelDependency.provideMissionFirebaseManager()
}