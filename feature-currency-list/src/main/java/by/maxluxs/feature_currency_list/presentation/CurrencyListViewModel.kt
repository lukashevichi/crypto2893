package by.maxluxs.feature_currency_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    init {
        getCurrencies()
    }

    private fun getCurrencies() {
        repository.getCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { result ->
                (result.getOrNull()
                    ?.map {
                        CurrencyModel(
                            name = it.name ?: "",
                            price = "",
                        )
                    } ?: emptyList())
                    .justSingle()
            }
            .subscribe({ _data.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()


    }
}

fun <T> T.justSingle() = Single.just(this)
