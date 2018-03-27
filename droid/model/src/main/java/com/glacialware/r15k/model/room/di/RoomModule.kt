package com.glacialware.r15k.model.room.di

import android.arch.persistence.room.Room
import android.content.Context
import com.glacialware.r15k.model.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val mContext: Context) {

    // Note: You should follow the singleton design pattern when instantiating an AppDatabase object, as each RoomDatabase instance is fairly expensive,
    // and you rarely need access to multiple instances.
    //
    // https://developer.android.com/training/data-storage/room/index.html
    @Provides
    @Singleton
    fun provideDatabase() = Room.databaseBuilder(mContext, AppDatabase::class.java, "r15k_ddbb").build()
}