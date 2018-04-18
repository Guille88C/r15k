package com.glacialware.r15k.viewmodel.model

import android.os.Parcel
import android.os.Parcelable

data class Mission(
    var id : Int = 0,
    var title : String = "",
    var description : String = "",
    var image : String = "",
    var completed : Boolean = false
): Parcelable {
    // ---- Builder ----
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())
    // ---- END Builder ----

    // ---- Parcelable ----
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeByte(if (completed) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mission> {
        override fun createFromParcel(parcel: Parcel): Mission {
            return Mission(parcel)
        }

        override fun newArray(size: Int): Array<Mission?> {
            return arrayOfNulls(size)
        }
    }
    // ---- END Parcelable ----

    // ---- Public ----
    fun fromRoom(mission: com.glacialware.r15k.model.room.Mission) {
        id = mission.id
        title = mission.title
        description = mission.description
        image = mission.image
        completed = mission.completed
    }

    fun toRoom(): com.glacialware.r15k.model.room.Mission {
        val mission = com.glacialware.r15k.model.room.Mission( title, description, image, completed)
        mission.id = id

        return mission
    }
    // ---- END Public ----
}