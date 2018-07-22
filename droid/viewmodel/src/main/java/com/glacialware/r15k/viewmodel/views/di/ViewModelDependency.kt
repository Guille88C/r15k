package com.glacialware.r15k.viewmodel.views.di

import android.content.Context
import com.glacialware.r15k.model.firebase.FirebaseMissionManager
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase

object ViewModelDependency {
    fun providePlayerDatabaseManager(context: Context) = ManagerPlayerDatabase(context.applicationContext)
    fun provideMissionFirebaseManager() = FirebaseMissionManager()
}