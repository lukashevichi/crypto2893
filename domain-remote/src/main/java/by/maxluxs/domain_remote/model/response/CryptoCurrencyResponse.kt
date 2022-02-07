package by.maxluxs.domain_remote.model.response

import com.google.gson.annotations.SerializedName

data class CryptoCurrencyResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("num_market_pairs") var numMarketPairs: Double? = null,
    @SerializedName("date_added") var dateAdded: String? = null,
    @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("max_supply") var maxSupply: Double? = null,
    @SerializedName("circulating_supply") var circulatingSupply: Double? = null,
    @SerializedName("total_supply") var totalSupply: Double? = null,
    @SerializedName("platform") var platform: Platform? = null,
    @SerializedName("cmc_rank") var cmcRank: Double? = null,
    @SerializedName("self_reported_circulating_supply") var selfReportedCirculatingSupply: String? = null,
    @SerializedName("self_reported_market_cap") var selfReportedMarketCap: String? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null,
    @SerializedName("quote") var quote: Quote? = Quote()
)