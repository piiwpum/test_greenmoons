package base_class

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import base_model.BaseResult

open class BaseViewModel : ViewModel() {
    private val _uiLoading = MutableLiveData<Boolean>()
    val uiLoading: LiveData<Boolean> = _uiLoading

    private val _uiNoInternet = MutableLiveData<String>()
    val uiNoInternet: LiveData<String> = _uiNoInternet

    private val _uiError = MutableLiveData<BaseResult.Error>()
    val uiError: LiveData<BaseResult.Error> = _uiError

    protected fun setLoading(type: Boolean = false) {
        _uiLoading.postValue(type)
    }

    protected fun setNoInternet(message: String = "") {
        _uiLoading.postValue(false)
        _uiNoInternet.postValue(message)
    }

    protected fun setError(message: BaseResult.Error) {
        _uiLoading.postValue(false)
        _uiError.postValue(message)
    }
}