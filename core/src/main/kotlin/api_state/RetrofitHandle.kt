package api_state

import android.content.Context
import base_model.BaseResult
import exts.isNetworkAvailable
import retrofit2.Response


suspend inline fun <T : Any> handleRetrofitResponse(
    context: Context,
    call: suspend () -> Response<T>
): BaseResult<T> {
    return try {
        if (context.isNetworkAvailable()) {
            val response = call.invoke()
            if (response.isSuccessful) {
                BaseResult.Success(response.body())
            } else {
                BaseResult.Error(code = response.code(), response.errorBody().toString())
            }
        } else {
            BaseResult.NoInternet
        }

    } catch (e: Exception) {
        BaseResult.Error(999, message = e.message)
    }
}