package by.maxluxs.feature_currency_details.presentation

import androidx.lifecycle.LiveData
import by.maxluxs.crypto2893.domain.values.CryptoCurrency

interface CurrencyDetailsViewModel {
    val model: LiveData<CryptoCurrency>
    val progress: LiveData<Boolean>
    val error: LiveData<Throwable>

    fun setModel(id: Int)
}