package by.maxluxs.domain_remote.api

import android.content.Context
import android.util.Log
import by.maxluxs.domain_remote.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton object for creating a marketCapApi object
 * @see MarketCapApi
 * */
object MarketCapApiFactory {

    /**
     * Create [MarketCapApi] object
     * */
    fun createMarketCapApi(): MarketCapApi = Retrofit.Builder()
        .baseUrl(MarketCapApiEndpoint.BASE)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()
        .create(MarketCapApi::class.java)

    /**
     * Creating a simple client http with logging, provided that the assembly is debug
     * */
    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(createHttpLoggingInterceptor())
            .build()

    }

    /**
     * Creating an Interceptor for Log Output
     * */
    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(
            object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    if (BuildConfig.DEBUG) Log.i("CRYPTO", message)
                }
            }
        ).apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
    }

}
