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
import com.ubaya.a160419009_newskoeid.viewmodel.FriendListViewModel
import kotlinx.android.synthetic.main.fragment_friends.*
import kotlinx.android.synthetic.main.fragment_home.refreshFriendsLayout

class FriendsFragment : Fragment() {
    private lateinit var viewModel: FriendListViewModel
    private val friendsAdapter = FriendsAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FriendListViewModel::class.java)
        viewModel.refresh()

        recViewFriends.layoutManager = LinearLayoutManager(context)
        recViewFriends.adapter = friendsAdapter

        refreshFriendsLayout.setOnRefreshListener {
            recViewFriends.visibility = View.GONE
            txtErrorFriends.visibility = View.GONE
            progressLoadFriends.visibility = View.VISIBLE
            viewModel.refresh()
            refreshFriendsLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.friendsLD.observe(viewLifecycleOwner, Observer {
            friendsAdapter.updateFriendList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorFriends.visibility = View.VISIBLE
            } else {
                txtErrorFriends.visibility = View.GONE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadFriends.visibility = View.GONE
                recViewFriends.visibility = View.VISIBLE
            } else {
                progressLoadFriends.visibility = View.VISIBLE
                recViewFriends.visibility = View.GONE

            }
        })
    }

}