package by.maxluxs.feature_currency_list.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.maxluxs.domain_remote.model.Result
import by.maxluxs.domain_remote.model.response.Currency
import by.maxluxs.domain_repository.CurrenciesRepository
import by.maxluxs.feature_currency_list.model.CurrencyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private fun Disposable.disposeOnCleared() = disposables.add(this)

    override fun onCleared() = disposables.clear()

    private val _data: MutableLiveData<List<CurrencyModel>> by lazy(::MutableLiveData)
    val data: LiveData<List<CurrencyModel>> get() = _data

    private val _error: MutableLiveData<Throwable> by lazy(::MutableLiveData)
    val error: LiveData<Throwable> get() = _error

    private val _progress: MutableLiveData<Boolean> by lazy(::MutableLiveData)
    val progress: LiveData<Boolean> get() = _progress

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        repository
            .getCurrencies()
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { it.toModel() }
            .subscribe({ _data.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    private fun <T> T.progress(isOn: Boolean): T {
        _progress.postValue(isOn)
        return this
    }

    private fun <T> T.justSingle() = Single.just(this)

    private fun Result<Currency>.toModel() =
        this.data
            .map { CurrencyModel(id = it.id ?: -1, name = it.name ?: "", price = "") }
            .justSingle()

}
