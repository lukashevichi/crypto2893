package by.maxluxs.feature_currency_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.maxluxs.domain_repository.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailsViewModel @Inject constructor() : ViewModel() {

    private val _model: MutableLiveData<by.maxluxs.domain_repository.model.Currency> by lazy(::MutableLiveData)
    val model: LiveData<by.maxluxs.domain_repository.model.Currency> get() = _model

    fun setModel(model: by.maxluxs.domain_repository.model.Currency) = _model.postValue(model)

}