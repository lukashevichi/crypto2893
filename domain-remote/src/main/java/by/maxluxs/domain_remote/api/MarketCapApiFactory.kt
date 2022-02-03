package by.maxluxs.domain_remote.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton object for creating a marketCapApi object
 * @see MarketCapApi
 * */
object MarketCapApiFactory {

    /**
     * Create [MarketCapApi] object
     * */
    fun createMarketCapApi() = Retrofit.Builder()
        .baseUrl(MarketCapApiEndpoints.BASE)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MarketCapApi::class.java)

}
