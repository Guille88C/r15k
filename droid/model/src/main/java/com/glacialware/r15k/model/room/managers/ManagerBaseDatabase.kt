package com.glacialware.r15k.model.room.managers

import android.content.Context
import com.glacialware.r15k.model.room.AppDatabase
import com.glacialware.r15k.model.room.di.DaggerRoomComponent
import com.glacialware.r15k.model.room.di.RoomComponent
import com.glacialware.r15k.model.room.di.RoomModule
import javax.inject.Inject

abstract class ManagerBaseDatabase(context: Context) {
    // ---- Dagger attributes ----

    private val mComponent: RoomComponent by lazy {
        DaggerRoomComponent.builder()
                .roomModule(RoomModule(context))
                .build()
    }

    @field:[Inject]
    protected lateinit var mDatabase: AppDatabase

    // ---- END Dagger attributes ----

    // ---- Builder ----

    init {
        mComponent.inject(this)
    }

    // ---- END Builder ----
}