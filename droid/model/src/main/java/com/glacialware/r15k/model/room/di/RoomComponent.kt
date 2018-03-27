package com.glacialware.r15k.model.room.di

import com.glacialware.r15k.model.room.managers.ManagerBaseDatabase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface RoomComponent  {
    fun inject(manager: ManagerBaseDatabase)
}