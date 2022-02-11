package by.maxluxs.feature_converter.presentation

import androidx.lifecycle.LiveData
import by.maxluxs.crypto2893.domain.values.CryptoCurrency

interface ConverterViewModel {

    val value: LiveData<CryptoCurrency>

    val result: LiveData<Double>

    val currencies: LiveData<List<CryptoCurrency>>

    val progress: LiveData<Boolean>

    val error: LiveData<Throwable>

    fun getCurrencies()

    fun convert(amount: Double)

}