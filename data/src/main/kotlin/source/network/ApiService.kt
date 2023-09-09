package source.network

import model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/apis/get_movie_avaiable")
    suspend fun getMovies() : Response<MovieResponse>

}