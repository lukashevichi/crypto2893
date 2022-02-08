package by.maxluxs.common_component_interfaces.view_model

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxViewModel : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun Disposable.disposeOnCleared() = disposables.add(this)

    override fun onCleared() = disposables.clear()

    fun <T> T.justSingle() = Single.just(this)

}