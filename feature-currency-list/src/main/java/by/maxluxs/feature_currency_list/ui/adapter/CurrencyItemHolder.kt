package by.maxluxs.feature_currency_list.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import by.maxluxs.feature_currency_list.databinding.CurrencyItemBinding
import by.maxluxs.feature_currency_list.model.CurrencyModel

/**
 *
 * */
class CurrencyItemHolder(
    private val binding: CurrencyItemBinding,
    private val callback: CurrencyCallback
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: CurrencyModel) {
        renderData(model)
        setListeners(model)
    }

    private fun renderData(model: CurrencyModel) {
        binding.name.text = model.name
        binding.price.text = model.price
    }

    private fun setListeners(model: CurrencyModel) {
        binding.item.setOnClickListener {
            callback.onClickCurrencyItem(model)
        }
    }

}