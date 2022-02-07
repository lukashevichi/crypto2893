package by.maxluxs.feature_currency_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.maxluxs.common_mapper.models_view.CurrencyModel
import by.maxluxs.domain_remote.model.Result
import by.maxluxs.domain_remote.model.response.CryptoCurrencyResponse
import by.maxluxs.domain_repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.math.RoundingMode
import java.text.DecimalFormat
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

    fun getCurrencies() {
        repository
            .getCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progress(true) }
            .doOnSuccess { progress(false) }
            .doOnError { progress(false) }
            .flatMap { it.toModel() }
            .subscribe({ _data.postValue(it) }, { _error.postValue(it) })
            .disposeOnCleared()
    }

    private fun <T> T.progress(isOn: Boolean): T {
        _progress.postValue(isOn)
        return this
    }

    private fun <T> T.justSingle() = Single.just(this)

    private fun Result<CryptoCurrencyResponse>.toModel(): Single<List<CurrencyModel>> =
        this.data
            .map {
                CurrencyModel(
                    id = it.id ?: -1,
                    name = it.name ?: "",
                    symbol = it.symbol ?: "",
                    slug = it.slug ?: "",
                    numMarketPairs = it.numMarketPairs.toString(),
                    dateAdded = it.dateAdded.toString(),
                    platform = it.platform?.name ?: "",
                    cmcRank = it.cmcRank.toString(),
                    lastUpdated = it.lastUpdated.toString(),
                    price = "${it.quote?.USD?.price?.roundToString()} $"
                )
            }
            .justSingle()

    fun Double.roundToString(): String {
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.CEILING
        return df.format(this)
    }

}
