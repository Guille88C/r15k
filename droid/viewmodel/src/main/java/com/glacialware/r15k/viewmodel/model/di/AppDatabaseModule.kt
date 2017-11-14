package com.glacialware.r15k.viewmodel.model.di

import android.arch.persistence.room.Room
import android.content.Context
import com.glacialware.r15k.model.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Guille on 14/11/2017.
 */
@Module
class AppDatabaseModule(private val context: Context) {
    @Singleton
    @Provides
    fun databaseInstance() : AppDatabase = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java).build()
}