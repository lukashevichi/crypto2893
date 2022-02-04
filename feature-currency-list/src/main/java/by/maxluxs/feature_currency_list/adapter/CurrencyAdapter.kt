package by.maxluxs.feature_currency_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.maxluxs.feature_currency_list.databinding.CurrencyItemBinding
import by.maxluxs.feature_currency_list.model.CurrencyModel

/**
 *
 * */
class CurrencyAdapter :
    ListAdapter<CurrencyModel, CurrencyItemHolder>(AsyncDifferConfig.Builder(comparator).build()),
    CurrencyCallback {

    var clickCallback: ((CurrencyModel) -> Unit)? = null

    companion object {
        val comparator = object : DiffUtil.ItemCallback<CurrencyModel>() {

            override fun areContentsTheSame(
                oldItem: CurrencyModel,
                newItem: CurrencyModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
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

    override fun onClickCurrencyItem(model: CurrencyModel) {
        clickCallback?.invoke(model)
    }

}