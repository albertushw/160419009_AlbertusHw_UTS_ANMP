package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.model.Profil
import com.ubaya.a160419009_newskoeid.util.Global

class ProfileDetailViewModel(application: Application):AndroidViewModel(application) {
    val profileLD = MutableLiveData<Profil>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun fetch(username:String){
        for(i in Global.listOfProfil){
            if(i.username == username){
                val result = Profil(i.username,i.name,i.email,i.bod,i.phone_num,i.slogans,i.photo_url)
                profileLD.value = result
            }
        }
    }
}