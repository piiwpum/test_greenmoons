package model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import base_model.Localize


@Entity(tableName = "favorite_movie")
data class FavoriteMovieEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Long? = null,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "posterUrl")
    val posterUrl: String,
    @ColumnInfo(name = "moveType")
    val moveType: String,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,
    @ColumnInfo(name = "detail")
    val detail: String,

)