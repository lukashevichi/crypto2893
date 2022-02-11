package by.maxluxs.data.network.coin_market_cap.api

import by.maxluxs.data.network.coin_market_cap.api.MarketCapApiEndpoint.Companion.CONVERSATION
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApiEndpoint.Companion.DATA
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApiEndpoint.Companion.LISTING
import by.maxluxs.data.network.coin_market_cap.model.Result
import by.maxluxs.data.network.coin_market_cap.model.response.ConversationResponse
import by.maxluxs.data.network.coin_market_cap.model.response.CryptoCurrencyResponse
import by.maxluxs.data.network.coin_market_cap.model.response.DataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * MarketCap api
 * */
interface MarketCapApi {

    /**
     * listingHistorical
     * @param limit - limiting response count
     * Full response
     * @see CryptoCurrencyResponse
     * */
    @GET(LISTING)
    fun listingHistorical(
        @Query("limit") limit: Int = 30
    ): Single<Result<List<CryptoCurrencyResponse>>>

    /**
     * listingHistorical
     * @param id
     * @param amount
     * Full response
     * @see ConversationResponse
     * */
    @GET(CONVERSATION)
    fun conversion(
        @Query("id") id: Int,
        @Query("amount") amount: Double,
    ): Single<Result<ConversationResponse>>

    /**
     * listingHistorical
     * @param id - limiting response count
     * Full response
     * @see ConversationResponse
     * */
    @GET(DATA)
    fun data(
        @Query("id") id: Int,
    ): Single<Result<DataResponse>>

}