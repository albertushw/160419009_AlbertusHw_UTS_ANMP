package com.ubaya.a160419009_newskoeid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.util.loadImage
import com.ubaya.a160419009_newskoeid.viewmodel.NewsDetailViewModel
import kotlinx.android.synthetic.main.fragment_news_detail.*
import kotlinx.android.synthetic.main.news_list_item.view.*


class NewsDetailFragment : Fragment() {
    private lateinit var viewModel: NewsDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var idNews = ""
        if(arguments!=null){
            idNews =NewsDetailFragmentArgs.fromBundle(requireArguments()).idnews
        }
        viewModel = ViewModelProvider(this).get(NewsDetailViewModel::class.java)
        viewModel.fetch(idNews)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.newsLD.observe(viewLifecycleOwner, Observer {
            textViewJudulNews.setText(it.title)
            txtDateTimeRilis.setText(it.rise_date)
            txtPenulis.setText(it.writer_name)
            txtBerita.setText(it.news)
            imageViewNewsDetail.loadImage(it.photo_url.toString(), progressBarNewsDetail)
        })
    }
}