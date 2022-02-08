package by.maxluxs.feature_currency_list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.domain_repository.model.Currency
import by.maxluxs.feature_currency_list.databinding.CurrencyItemBinding

/**
 *
 * */
class CurrencyAdapter :
    ListAdapter<Currency, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    CurrencyCallback {

    var clickCallback: ((Currency) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<Currency>() {

            override fun areContentsTheSame(
                oldItem: Currency,
                newItem: Currency
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyItemHolder {
        val binding =
            CurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyItemHolder(binding, this)
    }

    override fun onBindViewHolder(holder: CurrencyItemHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onClickCurrencyItem(model: Currency) {
        clickCallback?.invoke(model)
    }

}