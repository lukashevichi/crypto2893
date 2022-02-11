package by.maxluxs.data.network.coin_market_cap.model.response

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD") var USD: USD? = USD(),
)