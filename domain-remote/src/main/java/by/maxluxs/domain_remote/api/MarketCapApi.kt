package by.maxluxs.domain_remote.api

import by.maxluxs.domain_remote.api.KEY.VALUE
import by.maxluxs.domain_remote.api.MarketCapApiEndpoints.BASE
import by.maxluxs.domain_remote.api.MarketCapApiEndpoints.Purpose.LISTING
import by.maxluxs.domain_remote.api.MarketCapApiEndpoints.Top.CRYPTOCURRENCY
import by.maxluxs.domain_remote.api.MarketCapApiEndpoints.Type.LATEST
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.Accept.ACCEPT_JSON
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.Accept.ENCODING_DEFLATE_GZIP
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.KEY
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * MarketCap api
 * */
interface MarketCapApi {

    /**
     * Listing
     * */
    @GET("$BASE$CRYPTOCURRENCY$LISTING$LATEST")
    @Headers(ACCEPT_JSON, "$KEY:$VALUE", ENCODING_DEFLATE_GZIP)
    fun <T> listing(): Result<T>

}