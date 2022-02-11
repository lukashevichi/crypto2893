package by.maxluxs.data.network.coin_market_cap.model.response

import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("price") var price: Double? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null
)