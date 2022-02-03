package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class BTC(
    @SerializedName("price") var price: Int? = null,
    @SerializedName("volume_24h") var volume24h: Int? = null,
    @SerializedName("volume_change_24h") var volumeChange24h: String? = null,
    @SerializedName("percent_change_1h") var percentChange1h: String? = null,
    @SerializedName("percent_change_24h") var percentChange24h: String? = null,
    @SerializedName("percent_change_7d") var percentChange7d: String? = null,
    @SerializedName("market_cap") var marketCap: Int? = null,
    @SerializedName("market_cap_dominance") var marketCapDominance: Int? = null,
    @SerializedName("fully_diluted_market_cap") var fullyDilutedMarketCap: Double? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null
)