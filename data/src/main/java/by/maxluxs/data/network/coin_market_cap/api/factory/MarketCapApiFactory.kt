package by.maxluxs.data.network.coin_market_cap.api.factory

import android.util.Log
import by.maxluxs.data.BuildConfig
import by.maxluxs.data.network.coin_market_cap.api.HeadersType.ACCEPT
import by.maxluxs.data.network.coin_market_cap.api.HeadersType.API_KEY
import by.maxluxs.data.network.coin_market_cap.api.HeadersType.CONTENT_TYPE
import by.maxluxs.data.network.coin_market_cap.api.HeadersValue.JSON
import by.maxluxs.data.network.coin_market_cap.api.HeadersValue.JSON_UTF
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApi
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApiEndpoint
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton object for creating a marketCapApi object
 * @see MarketCapApi
 * */
object MarketCapApiFactory {

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    /**
     * Create [MarketCapApi] object
     * */
    fun create(): MarketCapApi = Retrofit.Builder()
        .baseUrl(MarketCapApiEndpoint.BASE)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(createOkHttpClient())
        .build()
        .create(MarketCapApi::class.java)

    /**
     * Creating a simple client http with logging, provided that the assembly is debug
     * */
    private fun createOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(createHttpLoggingInterceptor())
            .addInterceptor(HeaderInterceptor)
            .build()

    /**
     * Creating an Interceptor for Log Output
     * */
    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    if (BuildConfig.DEBUG) Log.i("CRYPTO", message)
                }
            }
        ).apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

    object HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader(ACCEPT, JSON)
                    .addHeader(CONTENT_TYPE, JSON_UTF)
                    .addHeader(API_KEY, BuildConfig.COIN_MARKET_CAP_API_KEY)
                    .build()
            )
        }
    }

}
