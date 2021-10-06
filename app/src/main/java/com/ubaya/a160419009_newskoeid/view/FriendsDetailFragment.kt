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
import com.ubaya.a160419009_newskoeid.viewmodel.FriendDetailViewModel
import com.ubaya.a160419009_newskoeid.viewmodel.NewsDetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_friends_detail.*
import kotlinx.android.synthetic.main.fragment_news_detail.*
import java.util.concurrent.TimeUnit

class FriendsDetailFragment : Fragment() {
    private lateinit var viewModel: FriendDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var username_friends = ""
        if(arguments!=null){
            username_friends =FriendsDetailFragmentArgs.fromBundle(requireArguments()).usernameFriends
        }
        viewModel = ViewModelProvider(this).get(FriendDetailViewModel::class.java)
        viewModel.fetch(username_friends)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.friendDetailLD.observe(viewLifecycleOwner, Observer {
            txtNameFriends.setText(it.name)
            txtUsernameFriendsDetail.setText(it.username)
            txtBodFriendsDetail.setText(it.bod)
            txtPhoneNumFriendsDetail.setText(it.phone_num)
            txtSlogansFriendsDetail.setText("'"+it.slogans+"'")
            txtMailFriendsDetail.setText(it.email)
            imageViewFriendsDetail.loadImage(it.photo_url.toString(), progressBarFriendDetail)
            var friends = it
            btnUnfollow.setOnClickListener {
                Observable.timer(1, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        MainActivity.showNotifikasi("NewsKoe.ID Unfollow Notification",
                            "Successfully Unfollow an Account from list Friends : " +friends.username.toString(),
                            R.drawable.ic_baseline_people_outline_24)
                    }
            }
        })
    }
}