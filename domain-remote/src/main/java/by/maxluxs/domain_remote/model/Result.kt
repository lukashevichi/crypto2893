package by.maxluxs.domain_remote.model

import com.google.gson.annotations.SerializedName

/**
 * Response data model
 * @see Status
 * */
data class Result<T>(
    @SerializedName("status") val status: Status? = Status(),
    @SerializedName("data") val data: ArrayList<T> = arrayListOf()
)

/**
 * Status response data model
 * */
data class Status(
    @SerializedName("timestamp")
    var timestamp: String? = null,
    @SerializedName("error_code")
    var errorCode: Int? = null,
    @SerializedName("error_message")
    var errorMessage: String? = null,
    @SerializedName("elapsed")
    var elapsed: Int? = null,
    @SerializedName("credit_count")
    var creditCount: Int? = null,
    @SerializedName("notice")
    var notice: String? = null
)
