package com.parth8199.flixter

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

private const val TAG = "MovieAdapter"

class MovieAdapter(private val context: Context, private val movies: List<Movie>) :

    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val orientation = context.resources.configuration.orientation
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        fun bind(movie: Movie) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                // Glide.with(context).load(movie.posterImageUlr).into(ivPoster)
                Glide.with(context)
                    .load(movie.posterImageUlr)
                    .placeholder(R.drawable.placeholder)
                    .dontTransform()
                    .error(R.drawable.errorimage)
                    .into(ivPoster)
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                //  Glide.with(context).load(movie.backdropImageUrl).into(ivPoster)
                Glide.with(context)
                    .load(movie.backdropImageUrl)
                    .placeholder(R.drawable.placeholder)
                    .dontTransform()
                    .error(R.drawable.errorimage)
                    .into(ivPoster)
            }

        }
    }
}
