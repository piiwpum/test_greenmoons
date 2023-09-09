package base_model

import com.google.gson.annotations.SerializedName


data class BaseResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: T?
) {
    data class Info(
        @SerializedName("count")
        val count: Int,
        @SerializedName("next")
        val next: String,
        @SerializedName("pages")
        val pages: Int,
        @SerializedName("prev")
        val prev: String
    )
}
