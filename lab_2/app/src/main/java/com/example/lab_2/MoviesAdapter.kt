package com.example.lab_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_2.model.Movie

class MoviesAdapter(
    private val movies: List<Movie>,
    private val navController: NavController
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val shortDescriptionTextView: TextView = itemView.findViewById(R.id.shortDescriptionTextView)
        val layout: CardView = itemView.findViewById(R.id.layout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        Glide.with(holder.imageView.context).load(movie.url).into(holder.imageView)

        holder.nameTextView.text = movie.name
        holder.shortDescriptionTextView.text = movie.shortDescription

        holder.layout.setOnClickListener {
            navController.navigate(
                MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    movie
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
