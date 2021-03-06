package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global

class HomeListViewModel(application: Application):AndroidViewModel(application) {

    val newsLD = MutableLiveData<List<News>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(){
        newsLD.value = Global.listOfNews
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}