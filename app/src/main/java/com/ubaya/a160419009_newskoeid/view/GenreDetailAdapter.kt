package com.ubaya.a160419009_newskoeid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.model.Genre
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.loadImage
import kotlinx.android.synthetic.main.news_list_item.view.*

class GenreDetailAdapter(val newsListGenre: ArrayList<News>):RecyclerView.Adapter<GenreDetailAdapter.GenreDetailViewHolder>() {
    class GenreDetailViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateNewsGenreList(newGenreNewsList:List<News>){
        newsListGenre.clear()
        newsListGenre.addAll(newGenreNewsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.news_list_item, parent, false)

        return GenreDetailAdapter.GenreDetailViewHolder(v)
    }

    override fun onBindViewHolder(holder: GenreDetailViewHolder, position: Int) {
        holder.view.txtIdNews.text = newsListGenre[position].id
        holder.view.textViewJudul.text = newsListGenre[position].title
        holder.view.txtTanggal.text = newsListGenre[position].rise_date
        holder.view.textViewPenulis.text = newsListGenre[position].writer_name
        holder.view.imageViewNews.loadImage(newsListGenre[position].photo_url.toString(), holder.view.progressBarCardHome)

        holder.view.btnView.setOnClickListener {
            val idNews = holder.view.txtIdNews.text.toString()
            val actions = GenreDetailFragmentDirections.actionGenreNewsDetail(idNews)
            Navigation.findNavController(it).navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return newsListGenre.size
    }
}