package by.maxluxs.currency_list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.currency_list.databinding.CurrencyItemBinding

/**
 *
 * */
class CurrencyAdapter :
    ListAdapter<CryptoCurrency, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    CurrencyCallback {

    var clickCallback: ((CryptoCurrency) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<CryptoCurrency>() {

            override fun areContentsTheSame(
                oldItem: CryptoCurrency,
                newItem: CryptoCurrency
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency): Boolean {
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

    override fun onClickCurrencyItem(model: CryptoCurrency) {
        clickCallback?.invoke(model)
    }

}