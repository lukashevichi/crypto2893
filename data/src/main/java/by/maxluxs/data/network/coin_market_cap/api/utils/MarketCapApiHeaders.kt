package by.maxluxs.data.network.coin_market_cap.api

/**
 * Accept headers endpoints
 * */
object HeadersType {
    const val ACCEPT = "Accept"
    const val ACCEPT_ENCODING = "Accept-Encoding"
    const val CONTENT_TYPE = "Content-Type"
    const val API_KEY = "X-CMC_PRO_API_KEY"
}

object HeadersValue {
    const val JSON = "application/json"
    const val DEFLATE_GZIP = ":deflate, gzip"
    const val JSON_UTF = "application/json; charset=utf-8"
}