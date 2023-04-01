package com.hyparz.assessment.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Results(
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("name") var name: Name? = Name(),
    @SerializedName("location") var location: Location? = Location(),
    @SerializedName("email") var email: String? = null,
    @SerializedName("login") var login: Login? = Login(),
    @SerializedName("dob") var dob: Dob? = Dob(),
    @SerializedName("registered") var registered: Registered? = Registered(),
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("cell") var cell: String? = null,
    @SerializedName("id") var id: Id? = Id(),
    @SerializedName("picture") var picture: Picture? = Picture(),
    @SerializedName("nat") var nat: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Name::class.java.classLoader),
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Login::class.java.classLoader),
        parcel.readParcelable(Dob::class.java.classLoader),
        parcel.readParcelable(Registered::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Id::class.java.classLoader),
        parcel.readParcelable(Picture::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeParcelable(name, flags)
        parcel.writeParcelable(location, flags)
        parcel.writeString(email)
        parcel.writeParcelable(login, flags)
        parcel.writeParcelable(dob, flags)
        parcel.writeParcelable(registered, flags)
        parcel.writeString(phone)
        parcel.writeString(cell)
        parcel.writeParcelable(id, flags)
        parcel.writeParcelable(picture, flags)
        parcel.writeString(nat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }

}