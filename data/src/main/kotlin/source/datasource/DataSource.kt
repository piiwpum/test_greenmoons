package source.datasource

import base_model.BaseResult
import model.MovieResponse

interface DataSource {
    suspend fun getMovies() : BaseResult<MovieResponse>

}