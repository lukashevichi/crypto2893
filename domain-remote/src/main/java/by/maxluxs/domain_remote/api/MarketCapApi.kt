package by.maxluxs.domain_remote.api

import retrofit2.http.GET
import retrofit2.http.Headers


interface MarketCapApi {

    @GET ("https://sandbox-api.coinmarketcap.com/v1/cryptocurrency/listings/latest")
    @Headers("Content-type:application/json", "X-CMC_PRO_API_KEY:${KEY.VALUE}")
    fun listing()

}