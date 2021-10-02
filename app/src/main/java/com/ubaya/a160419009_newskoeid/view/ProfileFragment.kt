package com.ubaya.a160419009_newskoeid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.util.Global
import com.ubaya.a160419009_newskoeid.util.loadImage
import com.ubaya.a160419009_newskoeid.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.news_list_item.view.*

class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.refresh()

        txtNama.setText(Global.listOfProfil[0].name)
        txtUsername.setText(Global.listOfProfil[0].username)
        txtSlogan.setText(Global.listOfProfil[0].slogans)
        imageViewProfilAwal.loadImage(Global.listOfProfil[0].photo_url, progressBarProfileMain)

        btnEditProfile.setOnClickListener {
            val idProfile = txtUsername.text.toString()
            val actions = ProfileFragmentDirections.actionDetailProfileFragment(idProfile)
            Navigation.findNavController(it).navigate(actions)
        }

        btnViewFriends.setOnClickListener {
            val actions = ProfileFragmentDirections.actionFriendsFragment()
            Navigation.findNavController(it).navigate(actions)
        }
    }
}