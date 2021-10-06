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
import com.ubaya.a160419009_newskoeid.viewmodel.HomeListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeListViewModel
    private val homeAdapter = HomeAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeListViewModel::class.java)
        viewModel.refresh()

        recViewHome.layoutManager = LinearLayoutManager(context)
        recViewHome.adapter = homeAdapter

        refreshFriendsLayout.setOnRefreshListener {
            recViewHome.visibility = View.GONE
            txtErrorHome.visibility = View.GONE
            progressLoadHome.visibility = View.VISIBLE
            viewModel.refresh()
            refreshFriendsLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.newsLD.observe(viewLifecycleOwner, Observer {
            homeAdapter.updateNewsList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorHome.visibility = View.VISIBLE
            } else {
                txtErrorHome.visibility = View.GONE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadHome.visibility = View.GONE
                recViewHome.visibility = View.VISIBLE
            } else {
                progressLoadHome.visibility = View.VISIBLE
                recViewHome.visibility = View.GONE

            }
        })
    }
}