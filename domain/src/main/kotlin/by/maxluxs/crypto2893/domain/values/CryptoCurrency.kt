package by.maxluxs.crypto2893.domain.values

data class CryptoCurrency(
    val id: Int,
    val name: String,
    val symbol: String,
    val price: String,
    val data: MetaData
) {
    companion object {
        val EMPTY = CryptoCurrency(
            id = -1,
            name = "",
            symbol = "",
            price = "",
            data = MetaData.EMPTY
        )
    }

    val slug get() = data.slug
    val dateAdded get() = data.dateAdded
    val platform get() = data.platform
    val cmcRank get() = data.cmcRank
    val lastUpdated = data.lastUpdated
}
