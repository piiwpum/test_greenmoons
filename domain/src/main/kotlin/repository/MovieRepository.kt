package repository

import base_model.BaseResult
import kotlinx.coroutines.flow.Flow
import model.MovieModel

interface MovieRepository {
    suspend fun getMovies(): Flow<BaseResult<List<MovieModel>>>
    suspend fun getFavoriteMovies(): Flow<BaseResult<List<MovieModel>>>
    suspend fun insertFavoriteMovie(model: MovieModel): Flow<Boolean>
}