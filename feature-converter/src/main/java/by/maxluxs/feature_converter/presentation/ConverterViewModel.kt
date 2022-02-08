package by.maxluxs.feature_converter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.maxluxs.common_component_interfaces.view_model.RxViewModel
import by.maxluxs.domain_repository.model.Currency
import by.maxluxs.domain_repository.repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : RxViewModel() {

    private val _value: MutableLiveData<String> by lazy(::MutableLiveData)
    val value: LiveData<String> get() = _value

    private val _result: MutableLiveData<String> by lazy(::MutableLiveData)
    val result: LiveData<String> get() = _result

    private val _currencies: MutableLiveData<List<Currency>> by lazy(::MutableLiveData)
    val currencies: LiveData<List<Currency>> get() = _currencies

    private val _progress: MutableLiveData<Boolean> by lazy(::MutableLiveData)
    val progress: LiveData<Boolean> get() = _progress

    private val _error: MutableLiveData<Throwable> by lazy(::MutableLiveData)
    val error: LiveData<Throwable> get() = _error

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        repository
            .getCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .subscribe({ _currencies.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    private fun <T> T.progress(isOn: Boolean): T {
        _progress.postValue(isOn)
        return this
    }

}
