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
    fun getCurrencies() = marketCapApi
        .map()
        .subscribeOn(io())

}