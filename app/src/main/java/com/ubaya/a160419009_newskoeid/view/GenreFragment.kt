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
import com.ubaya.a160419009_newskoeid.viewmodel.GenreListViewModel
import com.ubaya.a160419009_newskoeid.viewmodel.HomeListViewModel
import kotlinx.android.synthetic.main.fragment_genre.*
import kotlinx.android.synthetic.main.fragment_home.*


class GenreFragment : Fragment() {
    private lateinit var viewModel: GenreListViewModel
    private val genreAdapter = GenreAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(GenreListViewModel::class.java)
        viewModel.refresh()

        recyclerViewGenre.layoutManager = LinearLayoutManager(context)
        recyclerViewGenre.adapter = genreAdapter

        refreshGenreLayout.setOnRefreshListener {
            recyclerViewGenre.visibility = View.GONE
            txtErrorGenre.visibility = View.GONE
            progressLoadGenre.visibility = View.VISIBLE
            viewModel.refresh()
            refreshGenreLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.genreLD.observe(viewLifecycleOwner, Observer {
            genreAdapter.updateGenreList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorGenre.visibility = View.VISIBLE
            } else {
                txtErrorGenre.visibility = View.GONE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadGenre.visibility = View.GONE
                recyclerViewGenre.visibility = View.VISIBLE
            } else {
                progressLoadGenre.visibility = View.VISIBLE
                recyclerViewGenre.visibility = View.GONE

            }
        })
    }
}