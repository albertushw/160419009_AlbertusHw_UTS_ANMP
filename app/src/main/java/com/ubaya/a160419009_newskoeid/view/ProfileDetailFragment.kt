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
import com.ubaya.a160419009_newskoeid.viewmodel.ProfileDetailViewModel
import kotlinx.android.synthetic.main.fragment_news_detail.*
import kotlinx.android.synthetic.main.fragment_profile_detail.*

class ProfileDetailFragment : Fragment() {
    private lateinit var viewModel: ProfileDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var username = ""
        if(arguments!=null){
            username = ProfileDetailFragmentArgs.fromBundle(requireArguments()).username.toString()
        }
        viewModel = ViewModelProvider(this).get(ProfileDetailViewModel::class.java)
        viewModel.fetch(username)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.profileLD.observe(viewLifecycleOwner, Observer {
            txtNameUpdate.setText(it.name)
            txtUsernameUpdate.setText(it.username)
            txtBodUpdate.setText(it.bod)
            txtSloganUpdate.setText(it.slogans)
            txtEmailUpdate.setText(it.email)
            txtPhoneNumberUpdate.setText(it.phone_num)
            imageViewProfil.loadImage(it.photo_url.toString(),progressBarProfilDetail)
        })
    }
}