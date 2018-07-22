package com.glacialware.r15k.model.room.managers

import android.content.Context
import com.glacialware.r15k.model.room.di.RoomDependency

abstract class ManagerBaseDatabase(context: Context) {
    // ---- Attributes ----
    protected var mDatabase = RoomDependency.provideDatabase(context)
    // ---- END Attributes ----
}