package presentation

import androidx.lifecycle.viewModelScope
import base_class.BaseViewModel
import base_model.BaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import model.MovieModel
import usecase.GetMoviesUseCase
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : BaseViewModel() {
    private val _stateUi: MutableStateFlow<MovieStateUi> = MutableStateFlow(MovieStateUi.Loading)
    fun onStateUi(): StateFlow<MovieStateUi> = _stateUi

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            getMoviesUseCase.invoke()
                .onStart { _stateUi.value = MovieStateUi.Loading }
                .collect {
                    when (it) {
                        is BaseResult.Success -> {
                            it.data?.let {
                                _stateUi.value = MovieStateUi.Success(it)
                            }
                        }

                        is BaseResult.Error -> {
                            _stateUi.value = MovieStateUi.Error
                        }

                        is BaseResult.NoInternet -> {
                            _stateUi.value = MovieStateUi.Error
                        }
                    }
                }
        }
    }


    sealed class MovieStateUi {
        object Loading : MovieStateUi()
        object Error : MovieStateUi()
        data class Success(val data: List<MovieModel>) : MovieStateUi()
    }

}