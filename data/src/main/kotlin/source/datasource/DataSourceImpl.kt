package source.datasource

import android.content.Context
import api_state.handleRetrofitResponse
import base_model.BaseResult
import dagger.hilt.android.qualifiers.ApplicationContext
import model.MovieResponse
import source.network.ApiService
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val remoteApi: ApiService,
) : DataSource {
    override suspend fun getMovies(): BaseResult<MovieResponse> {
        return handleRetrofitResponse(context) {
            remoteApi.getMovies()
        }
    }

}