package by.maxluxs.feature_currency_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.maxluxs.common_component_interfaces.view_model.RxViewModel
import by.maxluxs.domain_repository.model.Currency
import by.maxluxs.domain_remote.model.Result
import by.maxluxs.domain_remote.model.response.CryptoCurrencyResponse
import by.maxluxs.domain_repository.repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : RxViewModel() {

    private val _data: MutableLiveData<List<Currency>> by lazy(::MutableLiveData)
    val data: LiveData<List<Currency>> get() = _data

    private val _error: MutableLiveData<Throwable> by lazy(::MutableLiveData)
    val error: LiveData<Throwable> get() = _error

    private val _progress: MutableLiveData<Boolean> by lazy(::MutableLiveData)
    val progress: LiveData<Boolean> get() = _progress

    init {
        getCurrencies()
    }

    fun getCurrencies() {
        repository
            .getCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .subscribe({ _data.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    private fun <T> T.progress(isOn: Boolean): T {
        _progress.postValue(isOn)
        return this
    }

}
