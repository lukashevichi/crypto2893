package by.maxluxs.feature_currency_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.maxluxs.common_mapper.models_view.CurrencyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailsViewModel @Inject constructor() : ViewModel() {

    private val _model: MutableLiveData<CurrencyModel> by lazy(::MutableLiveData)
    val model: LiveData<CurrencyModel> get() = _model

    fun setModel(model: CurrencyModel) = _model.postValue(model)

}