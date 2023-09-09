package presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import base_class.BaseFragment
import bundle.MovieDetailBundle
import dagger.hilt.android.AndroidEntryPoint
import features.movie.R
import features.movie.databinding.FragmentMovieBinding
import kotlinx.coroutines.launch
import model.MovieModel
import nav_option.NavigateOption
import presentation.MovieViewModel.*
import presentation.MovieViewModel.MovieStateUi.*

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>() {
    override val layoutId: Int = R.layout.fragment_movie
    private val vm: MovieViewModel by viewModels()
    private val mAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun updateUI(view: View, savedInstanceState: Bundle?) {
        setAdapter()
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
        binding.btnFavorite.setOnClickListener {
            navigateToFavoriteMovie()
        }
        mAdapter.onClick = {
            navigateToMovieDetail(it)
        }
        binding.edtSearch.doAfterTextChanged {
            mAdapter.filter(it.toString().trim())
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
                binding.edtSearch.isEnabled = false
            }

            is Success -> {
                binding.shimmer.apply {
                    visibility = View.GONE
                    stopShimmer()
                }
                binding.edtSearch.isEnabled = true
                binding.rvMovie.visibility = View.VISIBLE
                mAdapter.setData(state.data, binding.edtSearch.text.toString().trim())
            }

            else -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_to_get_movie_from_api),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun navigateToFavoriteMovie() {
        navController.navigate(
            MovieFragmentDirections.actionMovieFragmentToMovieFavoriteFragment(),
            NavigateOption.fromRight
        )
    }

    private fun navigateToMovieDetail(data: MovieModel) {
        navController.navigate(
            MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
                bundle = MovieDetailBundle(data)
            ), NavigateOption.fromRight
        )
    }
}