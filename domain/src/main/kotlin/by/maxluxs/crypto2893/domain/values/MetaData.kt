package by.maxluxs.crypto2893.domain.values

data class MetaData(
    val slug: String = "",
    val dateAdded: String = "",
    val platform: String = "",
    val cmcRank: String = "",
    val lastUpdated: String = "",
    val category: String = "",
    val description: String = "",
    val logo: String = "",
    val subreddit: String = "",
    val notice: String = "",
    val tags: List<String> = listOf(),
    val tag_names: List<String> = listOf(),
    val twitterUsername: String = "",
    val dateLaunched: String = "",
    val contractAddress: List<String> = listOf()
) {
    companion object {
        val EMPTY = MetaData(
            slug = "",
            dateAdded = "",
            platform = "",
            cmcRank = "",
            lastUpdated = "",
            category = "",
            description = "",
            logo = "",
            subreddit = "",
            notice = "",
            tags = listOf(),
            tag_names = listOf(),
            twitterUsername = "",
            dateLaunched = "",
            contractAddress = listOf()
        )
    }
}