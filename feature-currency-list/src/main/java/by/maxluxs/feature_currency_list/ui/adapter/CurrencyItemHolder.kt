package by.maxluxs.feature_currency_list.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.domain_repository.model.Currency
import by.maxluxs.feature_currency_list.databinding.CurrencyItemBinding

/**
 *
 * */
class CurrencyItemHolder(
    private val binding: CurrencyItemBinding,
    private val callback: CurrencyCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: Currency) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: Currency) {
        binding.name.text = model.name
        binding.price.text = model.price
    }

    private fun setListeners(model: Currency) {
        binding.item.setOnClickListener {
            callback.onClickCurrencyItem(model)
        }
    }

}