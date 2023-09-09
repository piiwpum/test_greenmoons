package presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import base_class.BaseViewModel
import base_model.BaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import model.MovieModel
import usecase.GetFavoriteMoviesUseCase
import usecase.InsertFavoriteMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val insertFavoriteMoviesUseCase: InsertFavoriteMoviesUseCase,
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : BaseViewModel() {

    private val _addToFavoriteSuccess = MutableLiveData<Boolean>()
    val addToFavoriteSuccess: LiveData<Boolean> = _addToFavoriteSuccess

    private val _isShowAddButton = MutableLiveData<Boolean>()
    val isShowAddButton: LiveData<Boolean> = _isShowAddButton


    fun addToFavorite(data: MovieModel) {
        viewModelScope.launch {
            insertFavoriteMoviesUseCase.invoke(data).collect {
                _addToFavoriteSuccess.postValue(it)
            }
        }
    }

    fun checkIsFavorite(data: MovieModel) {
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().collect {
                when (it) {
                    is BaseResult.Success -> {
                        _isShowAddButton.postValue(it.data.orEmpty().find { it.id == data.id } == null)
                    }
                    else -> {
                        _isShowAddButton.postValue(true)
                    }
                }
            }
        }
    }
}