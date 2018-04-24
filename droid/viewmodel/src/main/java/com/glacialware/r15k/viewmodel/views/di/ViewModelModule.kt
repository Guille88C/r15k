package com.glacialware.r15k.viewmodel.views.di

import android.content.Context
import com.glacialware.r15k.model.firebase.FirebaseMissionManager
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import com.glacialware.r15k.viewmodel.scopes.PerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private val context: Context) {
    @PerViewModel
    @Provides
    fun providePlayerDatabaseManager() = ManagerPlayerDatabase(context.applicationContext)

    @PerViewModel
    @Provides
    fun provideMissionFirebaseManager() = FirebaseMissionManager()
}