package by.maxluxs.domain_remote.api

/**
 *  Singleton object to provide constant endpoint values
 *  Description cited from https://coinmarketcap.com/api/documentation/v1/#section/Endpoint-Overview
 * */
class MarketCapApiEndpoint {

    companion object {
        /**
         * Base domain MarketCapApiEndpoints
         * */
        const val BASE = "http://sandbox-api.coinmarketcap.com/v1/"
    }

    /**
     * The CoinMarketCap API is divided into 8 top-level categories
     * */
    class Endpoint(private val path: String) {

        companion object {
            fun cryptoCurrency() = Endpoint("$BASE/cryptocurrency/")
            fun exchange() = Endpoint("$BASE/exchange/")
            fun globalMetrics() = Endpoint("$BASE/global-metrics/")
            fun tools() = Endpoint("$BASE/tools/")
            fun blockchain() = Endpoint("$BASE/blockchain/")
            fun fiat() = Endpoint("$BASE/fiat/")
            fun partners() = Endpoint("$BASE/partners/")
            fun key() = Endpoint("$BASE/key/")
        }

        /**
         * Cryptocurrency and exchange endpoints provide 2 different ways of accessing
         * data depending on purpose
         * Listing endpoints
         * Flexible paginated - /listings/ - endpoints allow you to sort and filter lists
         * of data like cryptocurrencies by market cap or exchanges by volume.
         * Item endpoints
         * Convenient ID-based resource endpoints like
         * - /quotes/ - and - /market-pairs/ - allow you to bundle several IDs;
         * for example, this allows you to get latest market quotes for a specific
         * set of cryptocurrencies in one call.
         * */
        class Purpose(private val path: String) {

            fun latest() = "${this.path}/latest"
            fun historical() = "${this.path}/historical"
            fun info() = "${this.path}/info"
            fun map() = "${this.path}/map"

        }

        fun listing() = Purpose("${this.path}listings")
        fun quotes() = Purpose("${this.path}quotes")
        fun marketPairs() = Purpose("${this.path}market-pairs")

    }

}
