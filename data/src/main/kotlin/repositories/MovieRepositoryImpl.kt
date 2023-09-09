package repositories

import base_model.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.MovieModel
import model.mapToData
import model.mapToDomain
import repository.MovieRepository
import source.datasource.DataSource
import source.datasource.LocalDataSource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): Flow<BaseResult<List<MovieModel>>> {
        return flow {
            val response = dataSource.getMovies()
            when (response) {
                is BaseResult.Success -> {
                    emit(BaseResult.Success(response.data?.mapToDomain()))
                }
                is BaseResult.Error -> {
                    emit(response)
                }
                is BaseResult.NoInternet ->{
                    emit(BaseResult.NoInternet)
                }
                else -> {
                }
            }
        }
    }

    override suspend fun getFavoriteMovies(): Flow<BaseResult<List<MovieModel>>> {
        return flow {
            val response = localDataSource.getFavoriteMovies()
            when (response) {
                is BaseResult.Success -> {
                    emit(BaseResult.Success(response.data?.map { it.mapToDomain() }))
                }
                is BaseResult.Error -> {
                    emit(response)
                }
                else -> {
                }
            }
        }
    }

    override suspend fun insertFavoriteMovie(model: MovieModel): Flow<Boolean> {
         return flow {
            val response = localDataSource.insertFavoriteMovies(model.mapToData())
            when (response) {
                is BaseResult.Success -> {
                    emit(true)
                }
                is BaseResult.Error -> {
                    emit(false)
                }
                else -> {
                    emit(false)
                }
            }
        }
    }
}