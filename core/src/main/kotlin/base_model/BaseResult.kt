package base_model

sealed class BaseResult<out T> {
    data class Success<T>(val data: T?) : BaseResult<T>()
    data class Error(val code: Int? = null, val message: String? = null) : BaseResult<Nothing>()
    object NoInternet : BaseResult<Nothing>()

}