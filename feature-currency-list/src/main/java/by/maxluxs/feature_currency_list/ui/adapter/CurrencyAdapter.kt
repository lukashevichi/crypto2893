package by.maxluxs.feature_currency_list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.feature_currency_list.databinding.CurrencyItemBinding
import by.maxluxs.common_mapper.models_view.CurrencyModel

/**
 *
 * */
class CurrencyAdapter :
    ListAdapter<by.maxluxs.common_mapper.models_view.CurrencyModel, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    CurrencyCallback {

    var clickCallback: ((by.maxluxs.common_mapper.models_view.CurrencyModel) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<by.maxluxs.common_mapper.models_view.CurrencyModel>() {

            override fun areContentsTheSame(
                oldItem: by.maxluxs.common_mapper.models_view.CurrencyModel,
                newItem: by.maxluxs.common_mapper.models_view.CurrencyModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: by.maxluxs.common_mapper.models_view.CurrencyModel, newItem: by.maxluxs.common_mapper.models_view.CurrencyModel): Boolean {
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

    override fun onClickCurrencyItem(model: by.maxluxs.common_mapper.models_view.CurrencyModel) {
        clickCallback?.invoke(model)
    }

}