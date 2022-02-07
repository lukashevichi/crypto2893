package by.maxluxs.domain_remote.api

import by.maxluxs.domain_remote.model.Result
import by.maxluxs.domain_remote.model.request.ListingRequest
import by.maxluxs.domain_remote.model.response.Currency
import io.reactivex.Single
import retrofit2.http.*

/**
 * MarketCap api
 * */
interface MarketCapApi {

    /**
     * Listing
     * */
    @GET("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
    fun <T> listing(@Body body: ListingRequest): Single<Result<T>>

    /**
     * Listing
     * */
    @GET("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest")
    fun <T> quotes(): Single<Result<T>>

    @GET("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/map")
    fun map(): Single<Result<Currency>>

}