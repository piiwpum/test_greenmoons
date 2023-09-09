package bundle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import model.MovieModel

@Parcelize
data class MovieDetailBundle(
    val data: MovieModel
) : Parcelable
