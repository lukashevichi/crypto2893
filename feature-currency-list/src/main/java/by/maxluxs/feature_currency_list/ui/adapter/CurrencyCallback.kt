package by.maxluxs.feature_currency_list.ui.adapter

import by.maxluxs.domain_repository.model.Currency

/**
 *
 * */
interface CurrencyCallback {

    fun onClickCurrencyItem(model: Currency)

}