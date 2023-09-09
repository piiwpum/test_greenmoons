package source.datasource

import api_state.handleRoomResponse
import base_model.BaseResult
import model.FavoriteMovieEntity
import source.local.MovieDao
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : LocalDataSource {
    override suspend fun getFavoriteMovies(): BaseResult<List<FavoriteMovieEntity>> {
        return handleRoomResponse {
            movieDao.getFavoriteMovies()
        }
    }

    override suspend fun insertFavoriteMovies(data: FavoriteMovieEntity): BaseResult<Long> {
        return handleRoomResponse {
            movieDao.insertFavoriteMovies(data)
        }
    }
}