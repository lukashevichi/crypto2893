package by.maxluxs.crypto2893.domain.repositories

import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import io.reactivex.Single

interface CurrenciesRepository {
    fun getCurrencies(): Single<List<CryptoCurrency>>
    fun conversion(currency: CryptoCurrency, amount: Double): Single<Double>
    fun getCurrency(id: Int): Single<CryptoCurrency>
}