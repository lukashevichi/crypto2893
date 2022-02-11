package by.maxluxs.feature_converter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.maxluxs.common.view_model.RxViewModel
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.crypto2893.domain.repositories.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class DefaultConverterViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : RxViewModel(), ConverterViewModel {

    private val _value: MutableLiveData<CryptoCurrency> by lazy(::MutableLiveData)
    override val value: LiveData<CryptoCurrency> get() = _value

    private val _result: MutableLiveData<Double> by lazy(::MutableLiveData)
    override val result: LiveData<Double> get() = _result

    private val _currencies: MutableLiveData<List<CryptoCurrency>> by lazy(::MutableLiveData)
    override val currencies: LiveData<List<CryptoCurrency>> get() = _currencies

    val currenciesModels get() = currencies.value ?: emptyList()

    private val _progress: MutableLiveData<Boolean> by lazy(::MutableLiveData)
    override val progress: LiveData<Boolean> get() = _progress

    private val _error: MutableLiveData<Throwable> by lazy(::MutableLiveData)
    override val error: LiveData<Throwable> get() = _error

    init {
        getCurrencies()
    }

    fun setValue(value: CryptoCurrency) = _value.postValue(value)

    override fun getCurrencies() {
        repository
            .getCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .subscribe({ _currencies.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    override fun convert(amount: Double) {
        repository.conversion(value.value ?: CryptoCurrency.EMPTY, amount)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .subscribe({ _result.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    private fun <T> T.progress(isOn: Boolean): T {
        _progress.postValue(isOn)
        return this
    }

}
