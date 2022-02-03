package by.maxluxs.domain_remote.api

/**
 * Singleton object to provide constant headers values
 * */
object MarketCapApiHeaders {

    /**
     * Accept headers endpoints
     * */
    object Accept {
        const val ACCEPT_JSON = "Accept: application/json"
        const val ENCODING_DEFLATE_GZIP = "Accept-Encoding: deflate, gzip"
    }

    /**
     * Key value of header KEY endpoints
     * */
    const val KEY = "X-CMC_PRO_API_KEY:"

}