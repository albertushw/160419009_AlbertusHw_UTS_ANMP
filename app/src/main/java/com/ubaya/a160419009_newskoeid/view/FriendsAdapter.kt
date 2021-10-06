package com.ubaya.a160419009_newskoeid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419009_newskoeid.R
import com.ubaya.a160419009_newskoeid.model.Friends
import com.ubaya.a160419009_newskoeid.util.loadImage
import kotlinx.android.synthetic.main.friends_list_item.view.*
import kotlinx.android.synthetic.main.genre_list_item.view.*
import kotlinx.android.synthetic.main.genre_list_item.view.btnViewNewsGenre
import kotlinx.android.synthetic.main.genre_list_item.view.imageViewGenre
import kotlinx.android.synthetic.main.genre_list_item.view.progressBarGenre
import kotlinx.android.synthetic.main.genre_list_item.view.txtGenre

class FriendsAdapter(val friendList:ArrayList<Friends>):RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {
    class FriendsViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateFriendList(newFriendList:List<Friends>){
        friendList.clear()
        friendList.addAll(newFriendList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.friends_list_item, parent, false)

        return FriendsAdapter.FriendsViewHolder(v)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.view.txtUsernameFriend.text = friendList[position].username
        holder.view.txtNamaFriends.text = friendList[position].name
        holder.view.imageViewFriends.loadImage(friendList[position].photo_url.toString(), holder.view.progressBarFriends)

        holder.view.btnViewFriendsDetail.setOnClickListener {
            val username_friends = holder.view.txtUsernameFriend.text.toString()
            val actions = FriendsFragmentDirections.actionFriendsFragmentToFriendsDetailFragment(username_friends)
            Navigation.findNavController(it).navigate(actions)
        }
    }

    override fun getItemCount(): Int {
        return friendList.size
    }
}