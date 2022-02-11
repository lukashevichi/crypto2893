package by.maxluxs.data.network.coin_market_cap.model.request

import by.maxluxs.data.network.coin_market_cap.model.response.Quote
import com.google.gson.annotations.SerializedName

data class ListingRequest(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("cmc_rank") var cmcRank: Int? = null,
    @SerializedName("num_market_pairs") var numMarketPairs: Int? = null,
    @SerializedName("circulating_supply") var circulatingSupply: Int? = null,
    @SerializedName("total_supply") var totalSupply: Int? = null,
    @SerializedName("max_supply") var maxSupply: Int? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null,
    @SerializedName("date_added") var dateAdded: String? = null,
    @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("platform") var platform: String? = null,
    @SerializedName("quote") var quote: Quote? = Quote()

)
