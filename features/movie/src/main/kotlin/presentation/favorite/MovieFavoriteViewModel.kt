package presentation.favorite

import android.util.Log
import androidx.lifecycle.viewModelScope
import base_class.BaseViewModel
import base_model.BaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import model.MovieModel
import usecase.GetFavoriteMoviesUseCase
import usecase.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MovieFavoriteViewModel @Inject constructor(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : BaseViewModel() {
    private val _stateUi: MutableStateFlow<MovieStateUi> = MutableStateFlow(MovieStateUi.Loading)
    fun onStateUi(): StateFlow<MovieStateUi> = _stateUi

    fun getFavoriteMovie() {
        viewModelScope.launch {
            getFavoriteMoviesUseCase.invoke().onStart {
                    _stateUi.value = MovieStateUi.Loading
                }.collect {
                    when (it) {
                        is BaseResult.Success -> {
                            if (it.data.orEmpty().isNotEmpty()) {
                                _stateUi.value = MovieStateUi.Success(it.data.orEmpty())
                            } else {
                                _stateUi.value = MovieStateUi.Empty
                            }
                        }
                        else -> {
                            _stateUi.value = MovieStateUi.Error
                        }
                    }
                }
        }
    }


    sealed class MovieStateUi {
        object Loading : MovieStateUi()
        object Error : MovieStateUi()
        object Empty : MovieStateUi()
        data class Success(val data: List<MovieModel>) : MovieStateUi()
    }

}