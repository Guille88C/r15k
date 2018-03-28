package com.glacialware.r15k.viewmodel.di

import android.content.Context
import com.glacialware.r15k.model.room.managers.ManagerPlayerDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDatabaseModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideDataBase() = ManagerPlayerDatabase(context.applicationContext)
}