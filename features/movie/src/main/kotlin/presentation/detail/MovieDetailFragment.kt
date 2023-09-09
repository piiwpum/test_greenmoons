package presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import base_class.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import features.movie.R
import features.movie.databinding.FragmentMovieDetailBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import model.MovieModel

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {
    override val layoutId: Int = R.layout.fragment_movie_detail

    private val vm: MovieDetailViewModel by viewModels()
    private val navArgs: MovieDetailFragmentArgs by navArgs()

    override fun updateUI(view: View, savedInstanceState: Bundle?) {
        navArgs.bundle.data.let {
            updateView(it)

        }
    }

    override fun observeViewModel() {
        vm.addToFavoriteSuccess.observe(viewLifecycleOwner) {
            updateStateAddToFavorite(it)
        }
        vm.isShowAddButton.observe(viewLifecycleOwner) {
            updateButton(isShow = it)
        }
    }

    override fun listener() {
        binding.btnAdd.setOnClickListener {
            vm.addToFavorite(navArgs.bundle.data)
        }
    }


    private fun updateView(data: MovieModel) {
        vm.checkIsFavorite(data)
        Glide.with(requireContext()).load(data.posterUrl.orEmpty())
            .transform(FitCenter(), RoundedCorners(24)).into(binding.imvPoster)

        binding.tvCategory.text = data.moveType
        binding.tvTitleMovie.text = data.title
        binding.tvDescMovie.text = data.detail

    }

    private fun updateButton(isShow: Boolean) {
        binding.btnAdd.visibility = if (isShow) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun updateStateAddToFavorite(isSuccess: Boolean) {
        if (isSuccess) {
            binding.btnAdd.visibility = View.GONE
            Toast.makeText(requireContext(), "Add to Favorite Success", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Add to Favorite Error", Toast.LENGTH_SHORT).show()
        }
    }
}