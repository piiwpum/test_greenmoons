package base_model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Localize(
    val th: String,
    val en: String
) : Parcelable