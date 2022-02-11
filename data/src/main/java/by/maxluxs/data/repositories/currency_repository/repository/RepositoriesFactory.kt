package by.maxluxs.data.repositories.currency_repository.repository

import by.maxluxs.data.network.coin_market_cap.api.MarketCapApi

/**
 *
 * */
object RepositoriesFactory {

    /**
     * Create MarketCapApi
     * @see MarketCapApi
     * */
    fun createCurrencyRepository(marketCapApi: MarketCapApi) = DefaultCurrenciesRepository(marketCapApi)

}