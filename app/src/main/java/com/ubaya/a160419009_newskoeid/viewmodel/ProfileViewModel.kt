package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.model.Profil
import com.ubaya.a160419009_newskoeid.util.Global

class ProfileViewModel(application: Application):AndroidViewModel(application) {

    val profileLD = MutableLiveData<List<Profil>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        profileLD.value = Global.listOfProfil
        loadingErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}