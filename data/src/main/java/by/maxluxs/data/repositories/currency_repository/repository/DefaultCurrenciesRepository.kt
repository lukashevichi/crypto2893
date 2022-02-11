package by.maxluxs.data.repositories.currency_repository.repository

import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.crypto2893.domain.repositories.CurrenciesRepository
import by.maxluxs.data.network.coin_market_cap.api.MarketCapApi
import by.maxluxs.data.repositories.currency_repository.mapper.CurrencyMapper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io

/**
 * CurrenciesRepository
 * @see MarketCapApi
 * */
class DefaultCurrenciesRepository(
    private val marketCapApi: MarketCapApi
) : CurrenciesRepository {

    /**
     * get Currencies - api/listing
     * */
    override fun getCurrencies() =
        marketCapApi
            .listingHistorical()
            .flatMap { Single.just(CurrencyMapper.responseToModel(it.data)) }
            .subscribeOn(io())

    override fun conversion(currency: CryptoCurrency, amount: Double): Single<Double> =
        marketCapApi
            .conversion(id = currency.id, amount = amount)
            .flatMap { Single.just(it.data.quote.USD?.price ?: .0) }
            .subscribeOn(io())

    override fun getCurrency(id: Int): Single<CryptoCurrency> =
        marketCapApi
            .data(id)
            .flatMap { Single.just(CurrencyMapper.responseMetaModelToModel(it.data, id)) }
            .subscribeOn(io())

}
