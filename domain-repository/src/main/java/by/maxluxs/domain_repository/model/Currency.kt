package by.maxluxs.domain_repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
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
