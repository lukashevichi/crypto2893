package by.maxluxs.domain_remote.api

/**
 *  Singleton object to provide constant endpoint values
 *  Description cited from https://coinmarketcap.com/api/documentation/v1/#section/Endpoint-Overview
 * */
object MarketCapApiEndpoints {

    /**
     * Base domain MarketCapApiEndpoints
     * */
    const val BASE = "https://sandbox-api.coinmarketcap.com/v1"

    /**
     * The CoinMarketCap API is divided into 8 top-level categories
     * */
    object Top {
        const val CRYPTOCURRENCY = "/cryptocurrency/"
        const val EXCHANGE = "/exchange/"
        const val GLOBAL_METRICS = "/global-metrics/"
        const val TOOLS = "/tools/"
        const val BLOCKCHAIN = "/blockchain/"
        const val FIAT = "/fiat/"
        const val PARTNERS = "/partners/"
        const val KEY = "/key/"
    }

    /**
     * Endpoint paths follow a pattern matching the type of data provided
     */
    object Type {
        const val LATEST = "/latest"
        const val HISTORICAL = "/historical"
        const val INFO = "/info"
        const val MAP = "/map"
    }

    // Cryptocurrency and exchange endpoints provide 2 different ways of accessing
    // data depending on purpose
    object Purpose {
        /**
         * Listing endpoints
         * Flexible paginated - /listings/ - endpoints allow you to sort and filter lists
         * of data like cryptocurrencies by market cap or exchanges by volume.
         * */
        const val LISTING = "/listings/"

        /**
         * Item endpoints
         * Convenient ID-based resource endpoints like
         * - /quotes/ - and - /market-pairs/ - allow you to bundle several IDs;
         * for example, this allows you to get latest market quotes for a specific
         * set of cryptocurrencies in one call.
         * */
        object Item {
            const val QUOTES = "/quotes/"
            const val MARKET_PAIRS = "/market-pairs/"
        }

    }

}
