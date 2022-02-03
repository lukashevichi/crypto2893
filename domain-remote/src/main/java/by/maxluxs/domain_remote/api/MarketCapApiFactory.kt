package by.maxluxs.domain_remote.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * */
object MarketCapApiFactory {

    private const val BASE = "https://sandbox-api.coinmarketcap.com"

    fun create() = Retrofit.Builder()
        .baseUrl(BASE)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MarketCapApi::class.java)

}
