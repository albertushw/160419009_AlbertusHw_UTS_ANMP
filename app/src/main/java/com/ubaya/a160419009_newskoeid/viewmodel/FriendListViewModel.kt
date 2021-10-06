package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.Friends
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global

class FriendListViewModel(application: Application):AndroidViewModel(application) {
    val friendsLD = MutableLiveData<List<Friends>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        friendsLD.value = Global.listOfFriends
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}