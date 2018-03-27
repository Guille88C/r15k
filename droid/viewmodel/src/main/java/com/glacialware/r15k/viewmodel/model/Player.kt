package com.glacialware.r15k.viewmodel.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by guill on 25/03/2018.
 */
data class Player(
        var id : Int = 0,
        val nick : String = "",
        val isDead : Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nick)
        parcel.writeByte(if (isDead) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}