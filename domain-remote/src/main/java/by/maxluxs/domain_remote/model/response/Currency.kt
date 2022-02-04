package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("rank") var rank: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("is_active") var isActive: Int? = null,
    @SerializedName("first_historical_data") var firstHistoricalData: String? = null,
    @SerializedName("last_historical_data") var lastHistoricalData: String? = null,
    @SerializedName("platform") var platform: String? = null
)