package model

import android.os.Parcelable
import base_model.Localize
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieModel(
    val id : Int?,
    val title : String?,
    val posterUrl : String?,
    val moveType : String?,
    val releaseDate : String?,
    val detail : String?
) : Parcelable