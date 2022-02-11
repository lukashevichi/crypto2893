package by.maxluxs.currency_list.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.currency_list.databinding.CurrencyItemBinding

/**
 *
 * */
class CurrencyItemHolder(
    private val binding: CurrencyItemBinding,
    private val callback: CurrencyCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: CryptoCurrency) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: CryptoCurrency) {
        binding.name.text = model.name
        binding.price.text = model.price
    }

    private fun setListeners(model: CryptoCurrency) {
        binding.item.setOnClickListener {
            callback.onClickCurrencyItem(model)
        }
    }

}