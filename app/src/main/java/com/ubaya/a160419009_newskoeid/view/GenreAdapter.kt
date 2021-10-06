package com.ubaya.a160419009_newskoeid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.model.Genre
import com.ubaya.a160419009_newskoeid.util.loadImage
import kotlinx.android.synthetic.main.genre_list_item.view.*

class GenreAdapter(val genreList:ArrayList<Genre>):RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
    class GenreViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateGenreList(newGenreList:List<Genre>){
        genreList.clear()
        genreList.addAll(newGenreList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.genre_list_item, parent, false)

        return GenreAdapter.GenreViewHolder(v)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.view.txtGenre.text = genreList[position].nama_genre
        holder.view.imageViewGenre.loadImage(genreList[position].icon_genre.toString(), holder.view.progressBarGenre)

        holder.view.btnViewNewsGenre.setOnClickListener {
            val nama_genre = holder.view.txtGenre.text.toString()
            val actions = GenreFragmentDirections.actionGenreDetailFragment(nama_genre)
            Navigation.findNavController(it).navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return genreList.size
    }


}