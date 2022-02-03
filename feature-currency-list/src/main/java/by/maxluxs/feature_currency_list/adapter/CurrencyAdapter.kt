package by.maxluxs.feature_currency_list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.common_pojo.Currency

/**
 *
 * */
class CurrencyAdapter :
    ListAdapter<Currency, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()) {

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Currency>() {

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CurrencyItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

}