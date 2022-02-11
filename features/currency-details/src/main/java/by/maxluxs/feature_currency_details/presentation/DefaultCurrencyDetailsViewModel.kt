package by.maxluxs.feature_currency_details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.maxluxs.common.view_model.RxViewModel
import by.maxluxs.crypto2893.domain.values.CryptoCurrency
import by.maxluxs.crypto2893.domain.repositories.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class DefaultCurrencyDetailsViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : RxViewModel(), CurrencyDetailsViewModel {

    private val _model: MutableLiveData<CryptoCurrency> by lazy(::MutableLiveData)
    override val model: LiveData<CryptoCurrency> get() = _model

    private val _progress: MutableLiveData<Boolean> by lazy(::MutableLiveData)
    override val progress: LiveData<Boolean> get() = _progress

    private val _error: MutableLiveData<Throwable> by lazy(::MutableLiveData)
    override val error: LiveData<Throwable> get() = _error

    override fun setModel(id: Int) {
        repository.getCurrency(id)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _progress.postValue(true) }
            .doOnSuccess { _progress.postValue(false) }
            .doOnError { _progress.postValue(false) }
            .subscribe({ _model.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

}