package by.maxluxs.currency_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.maxluxs.common.view_model.RxViewModel
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.crypto2893.domain.repositories.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : RxViewModel() {

    private val _data: MutableLiveData<List<CryptoCurrency>> by lazy(::MutableLiveData)
    val data: LiveData<List<CryptoCurrency>> get() = _data

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
