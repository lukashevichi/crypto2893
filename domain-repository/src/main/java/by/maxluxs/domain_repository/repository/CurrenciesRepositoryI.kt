package by.maxluxs.domain_repository.repository

import by.maxluxs.domain_repository.model.Currency
import io.reactivex.Single

interface CurrenciesRepositoryI {

    fun getCurrencies(): Single<List<Currency>>

}