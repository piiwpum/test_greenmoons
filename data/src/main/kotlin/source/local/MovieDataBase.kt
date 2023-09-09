package source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import model.FavoriteMovieEntity

@Database(entities = [FavoriteMovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

}