package com.ubaya.a160419009_newskoeid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.loadImage
import kotlinx.android.synthetic.main.news_list_item.view.*

class HomeAdapter(val newsList:ArrayList<News>):RecyclerView.Adapter<HomeAdapter.NewsViewHolder>(){
    class NewsViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateNewsList(newNewsList:List<News>){
        newsList.clear()
        newsList.addAll(newNewsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //load layout di recycler view
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.news_list_item, parent, false)

        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.view.txtIdNews.text = newsList[position].id
        holder.view.textViewJudul.text = newsList[position].title
        holder.view.txtTanggal.text = newsList[position].rise_date
        holder.view.textViewPenulis.text = newsList[position].writer_name
        holder.view.imageViewNews.loadImage(newsList[position].photo_url.toString(), holder.view.progressBarCardHome)

        holder.view.btnView.setOnClickListener {
            val idNews = holder.view.txtIdNews.text.toString()
            val actions = HomeFragmentDirections.actionHNewsDetail(idNews)
            Navigation.findNavController(it).navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}