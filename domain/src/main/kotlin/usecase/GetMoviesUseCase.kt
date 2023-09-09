package usecase

import base_model.BaseResult
import kotlinx.coroutines.flow.Flow
import model.MovieModel
import repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun invoke(): Flow<BaseResult<List<MovieModel>>> {
        return repository.getMovies()
    }
}