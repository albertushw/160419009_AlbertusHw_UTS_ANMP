package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.a160419009_newskoeid.model.Friends
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global

class FriendDetailViewModel(application: Application): AndroidViewModel(application) {

    val friendDetailLD = MutableLiveData<Friends>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun fetch(username:String){
        for(i in Global.listOfFriends){
            if(i.username == username){
                val result = Friends(i.username,i.name,i.email,i.bod,i.phone_num,i.slogans,i.photo_url)
                friendDetailLD.value = result
            }
        }
    }
}