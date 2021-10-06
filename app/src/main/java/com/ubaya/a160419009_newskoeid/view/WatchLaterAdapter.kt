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

class WatchLaterAdapter(val WatchLaterNewsList: ArrayList<News>): RecyclerView.Adapter<WatchLaterAdapter.WatchLaterViewHolder>() {
    class WatchLaterViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateWatchLaterList(newWatchLaterList:List<News>){
        WatchLaterNewsList.clear()
        WatchLaterNewsList.addAll(newWatchLaterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchLaterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.news_list_item, parent, false)

        return WatchLaterAdapter.WatchLaterViewHolder(v)
    }

    override fun onBindViewHolder(holder: WatchLaterViewHolder, position: Int) {
        holder.view.txtIdNews.text = WatchLaterNewsList[position].id
        holder.view.textViewJudul.text = WatchLaterNewsList[position].title
        holder.view.txtTanggal.text = WatchLaterNewsList[position].rise_date
        holder.view.textViewPenulis.text = WatchLaterNewsList[position].writer_name
        holder.view.imageViewNews.loadImage(WatchLaterNewsList[position].photo_url.toString(), holder.view.progressBarCardHome)

        holder.view.btnView.setOnClickListener {
            val idNews = holder.view.txtIdNews.text.toString()
            val actions = WatchLaterFragmentDirections.actionWLNewsDetailFragment(idNews)
            Navigation.findNavController(it).navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return WatchLaterNewsList.size
    }
}