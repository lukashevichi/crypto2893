package by.maxluxs.domain_remote.api

import by.maxluxs.domain_remote.api.KEY.VALUE
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.Accept.ACCEPT_JSON
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.Accept.ENCODING_DEFLATE_GZIP
import by.maxluxs.domain_remote.api.MarketCapApiHeaders.KEY
import by.maxluxs.domain_remote.model.request.ListingRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * MarketCap api
 * */
interface MarketCapApi {

    /**
     * Listing
     * */
    @GET("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
    @Headers(ACCEPT_JSON, "$KEY:$VALUE", ENCODING_DEFLATE_GZIP)
    fun <T> listing(@Body body: ListingRequest): Single<Result<T>>

    /**
     * Listing
     * */
    @GET("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest")
    @Headers(ACCEPT_JSON, "$KEY:$VALUE", ENCODING_DEFLATE_GZIP)
    fun <T> quotes(): Single<Result<T>>

}