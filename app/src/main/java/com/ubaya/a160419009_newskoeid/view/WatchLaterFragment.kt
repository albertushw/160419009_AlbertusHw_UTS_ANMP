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
import com.ubaya.a160419009_newskoeid.viewmodel.WatchLaterViewModel
import kotlinx.android.synthetic.main.fragment_genre.*
import kotlinx.android.synthetic.main.fragment_watch_later.*

class WatchLaterFragment : Fragment() {
    private lateinit var viewModel: WatchLaterViewModel
    private val watchLaterAdapter = WatchLaterAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watch_later, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(WatchLaterViewModel::class.java)
        viewModel.refresh()

        recyclerViewWatchLater.layoutManager = LinearLayoutManager(context)
        recyclerViewWatchLater.adapter = watchLaterAdapter

        watchLaterSwipeRefresh.setOnRefreshListener {
            recyclerViewWatchLater.visibility = View.GONE
            txtErrorWatchLater.visibility = View.GONE
            progressLoadWatchLater.visibility = View.VISIBLE
            viewModel.refresh()
            watchLaterSwipeRefresh.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.watchLaterLD.observe(viewLifecycleOwner, Observer {
            watchLaterAdapter.updateWatchLaterList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorWatchLater.visibility = View.VISIBLE
            } else {
                txtErrorWatchLater.visibility = View.GONE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadWatchLater.visibility = View.GONE
                recyclerViewWatchLater.visibility = View.VISIBLE
            } else {
                progressLoadWatchLater.visibility = View.VISIBLE
                recyclerViewWatchLater.visibility = View.GONE

            }
        })
    }
}