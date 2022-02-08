package by.maxluxs.domain_repository.repository

import by.maxluxs.domain_remote.api.MarketCapApi
import by.maxluxs.domain_repository.mapper.CurrencyMapper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

/**
 * CurrenciesRepository
 * @see MarketCapApi
 * */
class CurrenciesRepository @Inject constructor(
    private val marketCapApi: MarketCapApi
) : CurrenciesRepositoryI {

    /**
     * get Map - api/map
     * */
    fun getMap() = marketCapApi
        .map()
        .subscribeOn(io())

    /**
     * get Currencies - api/listing
     * */
    override fun getCurrencies() = marketCapApi
        .listingHistorical()
        .flatMap { Single.just(CurrencyMapper.responseToModel(it.data)) }
        .subscribeOn(io())

    /**
     * get Currencies - api/listing
     * */
    fun getCurrenciesShortResponse() = marketCapApi
        .listingHistoricalShort()
        .subscribeOn(io())

}
