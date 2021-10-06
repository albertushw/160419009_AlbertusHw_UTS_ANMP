package com.ubaya.a160419009_newskoeid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.viewmodel.GenreDetailViewModel
import com.ubaya.a160419009_newskoeid.viewmodel.HomeListViewModel
import kotlinx.android.synthetic.main.fragment_genre_detail.*
import kotlinx.android.synthetic.main.fragment_home.*


class GenreDetailFragment : Fragment() {
    private lateinit var viewModel: GenreDetailViewModel
    private val GenreDetailAdapter = GenreDetailAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var namaGenre = ""
        if(arguments!=null){
            namaGenre =GenreDetailFragmentArgs.fromBundle(requireArguments()).namaGenre
        }
        viewModel = ViewModelProvider(this).get(GenreDetailViewModel::class.java)
        viewModel.refresh(namaGenre)

        recyclerViewGenreDetail.layoutManager = LinearLayoutManager(context)
        recyclerViewGenreDetail.adapter = GenreDetailAdapter

        refreshGenreDetailLayout.setOnRefreshListener {
            recyclerViewGenreDetail.visibility = View.GONE
            txtErrorGenreDetail.visibility = View.GONE
            progressLoadGenreGenre.visibility = View.VISIBLE
            viewModel.refresh(namaGenre)
            refreshGenreDetailLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.genreDetailLD.observe(viewLifecycleOwner, Observer {
            GenreDetailAdapter.updateNewsGenreList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorGenreDetail.visibility = View.VISIBLE
            } else {
                txtErrorGenreDetail.visibility = View.GONE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadGenreGenre.visibility = View.GONE
                recyclerViewGenreDetail.visibility = View.VISIBLE
            } else {
                progressLoadGenreGenre.visibility = View.VISIBLE
                recyclerViewGenreDetail.visibility = View.GONE

            }
        })
    }

}