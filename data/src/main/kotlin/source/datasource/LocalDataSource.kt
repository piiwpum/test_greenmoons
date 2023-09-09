package source.datasource

import base_model.BaseResult
import model.FavoriteMovieEntity

interface LocalDataSource {
    suspend fun getFavoriteMovies(): BaseResult<List<FavoriteMovieEntity>>
    suspend fun insertFavoriteMovies(favoriteMovieEntity: FavoriteMovieEntity): BaseResult<Long>
}