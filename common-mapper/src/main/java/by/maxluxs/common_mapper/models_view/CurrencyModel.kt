package by.maxluxs.common_mapper.models_view

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyModel(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    val numMarketPairs: String,
    val dateAdded: String,
    val platform: String,
    val cmcRank: String,
    val lastUpdated: String,
    val price: String
) : Parcelable
