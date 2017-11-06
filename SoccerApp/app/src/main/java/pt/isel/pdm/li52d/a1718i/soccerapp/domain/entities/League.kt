package pt.isel.pdm.li52d.a1718i.soccerapp.domain.entities

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by lfalcao on 16/10/2017.
 */
data class League(val id: Int, val name: String, val shortName: String, val currentMatchday: Int, val numberOfMatchdays: Int, val imageUrl: String?, val image: Bitmap?) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readParcelable(Bitmap::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(shortName)
        parcel.writeInt(currentMatchday)
        parcel.writeInt(numberOfMatchdays)
        parcel.writeString(imageUrl)
        parcel.writeParcelable(image, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<League> {
        override fun createFromParcel(parcel: Parcel): League {
            return League(parcel)
        }

        override fun newArray(size: Int): Array<League?> {
            return arrayOfNulls(size)
        }
    }

}