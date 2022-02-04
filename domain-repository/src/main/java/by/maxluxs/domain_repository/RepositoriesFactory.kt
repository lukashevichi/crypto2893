package by.maxluxs.domain_repository

import by.maxluxs.domain_remote.api.MarketCapApi

/**
 *
 * */
object RepositoriesFactory {

    /**
     * Create MarketCapApi
     * @see MarketCapApi
     * */
    fun createCurrencyRepository(marketCapApi: MarketCapApi) = CurrenciesRepository(marketCapApi)

}