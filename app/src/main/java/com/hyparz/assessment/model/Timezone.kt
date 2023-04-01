package com.hyparz.assessment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Timezone(
    @SerializedName("offset") var offset: String? = null,
    @SerializedName("description") var description: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this() {
        this.offset = parcel.readString()
        this.description = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(offset)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Timezone> {
        override fun createFromParcel(parcel: Parcel): Timezone {
            return Timezone(parcel)
        }

        override fun newArray(size: Int): Array<Timezone?> {
            return arrayOfNulls(size)
        }
    }
}