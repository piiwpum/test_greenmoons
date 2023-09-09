package presentation.favorite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import base_class.BaseFragment
import bundle.MovieDetailBundle
import dagger.hilt.android.AndroidEntryPoint
import features.movie.R
import features.movie.databinding.FragmentMovieFavoriteBinding
import kotlinx.coroutines.launch
import model.MovieModel
import nav_option.NavigateOption
import presentation.MovieAdapter
import presentation.favorite.MovieFavoriteViewModel.*
import presentation.favorite.MovieFavoriteViewModel.MovieStateUi.*

@AndroidEntryPoint
class MovieFavoriteFragment : BaseFragment<FragmentMovieFavoriteBinding>() {
    override val layoutId: Int = R.layout.fragment_movie_favorite
    private val vm: MovieFavoriteViewModel by viewModels()
    private val mAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun updateUI(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        vm.getFavoriteMovie()
    }

    private fun setAdapter() {
        binding.rvMovie.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }
    }

    override fun observeViewModel() {
        lifecycleScope.launch {
            vm.onStateUi().collect {
                updateStateUi(it)
            }
        }
    }

    override fun listener() {
        mAdapter.onClick = {
            navigateToMovieDetail(it)
        }
    }

    private fun updateStateUi(state: MovieStateUi) {
        when (state) {
            is Loading -> {
                binding.shimmer.apply {
                    visibility = View.VISIBLE
                    startShimmer()
                }
                binding.rvMovie.visibility = View.GONE
            }

            is Success -> {
                binding.shimmer.apply {
                    visibility = View.GONE
                    stopShimmer()
                }
                binding.rvMovie.visibility = View.VISIBLE
                mAdapter.setData(state.data)
            }

            is Empty -> {
                Toast.makeText(requireContext(), getString(R.string.empty_favorite_movie), Toast.LENGTH_SHORT).show()
            }

            else -> {
                Toast.makeText(requireContext(), getString(R.string.error_get_favorite_movie), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMovieDetail(data: MovieModel) {
        navController.navigate(
            MovieFavoriteFragmentDirections.actionMovieFavoriteFragmentToMovieDetailFragment(
                bundle = MovieDetailBundle(data)
            ), NavigateOption.fromRight
        )
    }
}