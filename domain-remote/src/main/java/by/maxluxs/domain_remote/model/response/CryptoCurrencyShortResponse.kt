package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class CryptoCurrencyShortResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("slug") var slug: String? = null,
)