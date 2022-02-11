package by.maxluxs.data.network.coin_market_cap.model.response

import com.google.gson.annotations.SerializedName

data class ConversationResponse(
    @SerializedName("amount") val amount: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("name") val name: String,
    @SerializedName("quote") val quote: Quote,
    @SerializedName("symbol") val symbol: String
)