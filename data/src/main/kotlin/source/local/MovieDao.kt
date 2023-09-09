package source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import model.FavoriteMovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM favorite_movie")
    suspend fun getFavoriteMovies(): List<FavoriteMovieEntity>

    @Insert(entity = FavoriteMovieEntity::class)
    suspend fun insertFavoriteMovies(entity: FavoriteMovieEntity): Long

}