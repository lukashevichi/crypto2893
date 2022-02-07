package by.maxluxs.domain_repository

import by.maxluxs.domain_remote.api.MarketCapApi
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

/**
 * CurrenciesRepository
 * @see MarketCapApi
 * */
class CurrenciesRepository @Inject constructor(
    private val marketCapApi: MarketCapApi
) {

    /**
     * get Currencies - api/map
     * */
    fun getMap() = marketCapApi
        .map()
        .subscribeOn(io())

    fun getCurrencies() = marketCapApi
        .listingHistorical()
        .subscribeOn(io())

}
