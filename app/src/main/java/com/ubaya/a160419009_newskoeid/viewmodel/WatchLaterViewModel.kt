package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global

class WatchLaterViewModel(application: Application): AndroidViewModel(application) {
    val watchLaterLD = MutableLiveData<List<News>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    var result = listOf<News>()
    fun refresh(){
        for(i in Global.listOfNews) {
            if (i.is_watch_later == "True") {
                result += News(i.id, i.title, i.writer_name, i.rise_date, i.news, i.genre, i.photo_url,i.is_watch_later)

            }
        }
        watchLaterLD.value = result
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}