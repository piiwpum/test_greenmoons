package usecase

import base_model.BaseResult
import kotlinx.coroutines.flow.Flow
import model.MovieModel
import repository.MovieRepository
import javax.inject.Inject

class InsertFavoriteMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun invoke(data: MovieModel): Flow<Boolean> {
        return repository.insertFavoriteMovie(data)
    }
}