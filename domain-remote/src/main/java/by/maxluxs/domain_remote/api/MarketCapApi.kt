package by.maxluxs.domain_remote.api

import by.maxluxs.domain_remote.model.Result
import by.maxluxs.domain_remote.model.request.ListingRequest
import by.maxluxs.domain_remote.model.response.CryptoCurrencyResponse
import by.maxluxs.domain_remote.model.response.MapResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * MarketCap api
 * */
interface MarketCapApi {

    /**
     * Listing
     * */
    @GET("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
    fun <T> listing(@Body body: ListingRequest): Single<Result<T>>

    /**
     * Quotes
     * */
    @GET("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest")
    fun <T> quotes(): Single<Result<T>>

    /**
     * Map
     * */
    @GET("https://pro-api.coinmarketcap.com/v1/cryptocurrency/map")
    fun map(
        @Query("limit") limit: Int = 10
    ): Single<Result<MapResponse>>

    /**
     * listingHistorical
     * @param limit - limiting response count
     * */
    @GET("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
    fun listingHistorical(
        @Query("limit") limit: Int = 20
    ): Single<Result<CryptoCurrencyResponse>>

}