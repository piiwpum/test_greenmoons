package presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import exts.toFormatDate
import features.movie.databinding.ItemMovieBinding
import model.MovieModel

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val mData: MutableList<MovieModel> = mutableListOf()
    private var mFilter: List<MovieModel> = listOf()

    var onClick: ((data: MovieModel) -> Unit)? = null


    fun setData(data: List<MovieModel>, query: String = "") {
        mData.clear()
        mData.addAll(data)
        mFilter = mData.filter { it.title?.contains(query, ignoreCase = true) ?: false }
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        mFilter = mData.filter { it.title?.contains(query, ignoreCase = true) ?: false }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mFilter.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(position)
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(position: Int) {
            mFilter[position].let {
                Glide.with(binding.root.context).load(it.posterUrl.orEmpty())
                    .transform(CenterCrop(), RoundedCorners(16)).into(binding.imvPoster)
                binding.tvCategory.text = it.moveType.orEmpty()
                binding.tvTitle.text = it.title
                binding.tvReleaseDate.text = it.releaseDate.orEmpty().toFormatDate()

                binding.container.setOnClickListener { _ ->
                    onClick?.invoke(it)
                }
            }

        }
    }

}