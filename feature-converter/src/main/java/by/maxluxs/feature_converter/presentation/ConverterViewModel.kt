package by.maxluxs.feature_converter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor() : ViewModel() {

    private val _value: MutableLiveData<String> by lazy(::MutableLiveData)
    val value: LiveData<String> get() = _value

    private val _result: MutableLiveData<String> by lazy(::MutableLiveData)
    val result: LiveData<String> get() = _result

    private val _currencies: MutableLiveData<String> by lazy(::MutableLiveData)
    val currencies: LiveData<String> get() = _currencies



}