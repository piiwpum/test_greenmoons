package api_state

import android.content.Context
import base_model.BaseResult
import exts.isNetworkAvailable
import retrofit2.Response


suspend inline fun <T : Any> handleRoomResponse(
    crossinline action: suspend () -> T
): BaseResult<T> {
    return try {
        val response = action()
        if (response != 0) {
            BaseResult.Success(data = response)
        } else {
            BaseResult.Error(
                message = response.toString(),
                code = null
            )
        }
    } catch (e: Exception) {
        BaseResult.Error(
            message = e.message,
            code = null
        )
    }

}