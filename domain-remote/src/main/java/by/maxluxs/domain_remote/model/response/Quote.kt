package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD") var USD: USD? = USD(),
)