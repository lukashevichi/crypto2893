package by.maxluxs.data.network.coin_market_cap.model.response

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("logo") var logo: String? = null,
    @SerializedName("subreddit") var subreddit: String? = null,
    @SerializedName("notice") var notice: String? = null,
    @SerializedName("tags") var tags: List<String>? = null,
    @SerializedName("tag-names") var tag_names: List<String>? = null,
    @SerializedName("platform") var platform: String? = null,
    @SerializedName("date_added") var dateAdded: String? = null,
    @SerializedName("twitter_username") var twitterUsername: String? = null,
    @SerializedName("date_launched") var dateLaunched: String? = null,
    @SerializedName("contract_address") var contractAddress: List<String>? = null
)

data class DataResponse(
    val metaData: HashMap<Int, DataResult>
)