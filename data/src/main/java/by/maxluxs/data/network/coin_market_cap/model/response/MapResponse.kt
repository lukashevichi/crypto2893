package by.maxluxs.data.network.coin_market_cap.model.response

import com.google.gson.annotations.SerializedName

data class MapResponse(
    @SerializedName("id") var id : Int,
    @SerializedName("name") var name : String,
    @SerializedName("symbol") var symbol : String,
    @SerializedName("slug") var slug : String,
    @SerializedName("rank") var rank : Int,
    @SerializedName("is_active") var isActive : Int,
    @SerializedName("first_historical_data") var firstHistoricalData : String,
    @SerializedName("last_historical_data") var lastHistoricalData : String,
    @SerializedName("platform") var platform : Platform? = null
)