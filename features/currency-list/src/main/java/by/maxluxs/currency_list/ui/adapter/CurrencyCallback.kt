package by.maxluxs.currency_list.ui.adapter

import by.maxluxs.crypto2893.domain.values.CryptoCurrency

/**
 *
 * */
interface CurrencyCallback {

    fun onClickCurrencyItem(model: CryptoCurrency)

}