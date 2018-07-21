package com.glacialware.r15k.model.room.di

import android.arch.persistence.room.Room
import android.content.Context
import com.glacialware.r15k.model.room.AppDatabase

object RoomDependency {
    fun provideDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "r15k_ddbb").build()
}