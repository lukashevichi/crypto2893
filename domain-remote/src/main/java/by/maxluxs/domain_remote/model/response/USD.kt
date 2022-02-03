package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("price") var price: Double? = null,
    @SerializedName("volume_24h") var volume24h: Int? = null,
    @SerializedName("volume_change_24h") var volumeChange24h: Double? = null,
    @SerializedName("percent_change_1h") var percentChange1h: Double? = null,
    @SerializedName("percent_change_24h") var percentChange24h: Double? = null,
    @SerializedName("percent_change_7d") var percentChange7d: Double? = null,
    @SerializedName("market_cap") var marketCap: Double? = null,
    @SerializedName("market_cap_dominance") var marketCapDominance: Int? = null,
    @SerializedName("fully_diluted_market_cap") var fullyDilutedMarketCap: Double? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null
)