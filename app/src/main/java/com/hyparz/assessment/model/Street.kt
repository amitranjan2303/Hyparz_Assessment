package com.hyparz.assessment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("number") var number: Int? = null,
    @SerializedName("name") var name: String? = null
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(number)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Street> {
        override fun createFromParcel(parcel: Parcel): Street {
            return Street(parcel)
        }

        override fun newArray(size: Int): Array<Street?> {
            return arrayOfNulls(size)
        }
    }

}