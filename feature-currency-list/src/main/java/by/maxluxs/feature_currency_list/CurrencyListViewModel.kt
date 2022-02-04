package by.maxluxs.feature_currency_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.maxluxs.feature_currency_list.model.CurrencyModel

class CurrencyListViewModel : ViewModel() {

    private val _data: MutableLiveData<CurrencyModel> by lazy(::MutableLiveData)
    private val data: LiveData<CurrencyModel> get() = _data

    private fun getData() {

    }

}