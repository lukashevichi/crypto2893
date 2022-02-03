package by.maxluxs.feature_currency_list.adapter

import androidx.recyclerview.widget.DiffUtil
import by.maxluxs.common_pojo.Currency

/**
 *
 * */
class CurrencyAdapter {

    companion object {
        val CURRENCY_COMPARATOR = object : DiffUtil.ItemCallback<Currency>() {

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem.uuid == newItem.uuid
            }

        }
    }

}