package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.ubaya.a160419009_newskoeid.model.Genre
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global

class GenreDetailViewModel(application: Application):AndroidViewModel(application) {
    val genreDetailLD = MutableLiveData<List<News>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    var result = listOf<News>()
    fun refresh(genreName:String){
        for(i in Global.listOfNews) {
            if (i.genre == genreName) {
                result += News(i.id, i.title, i.writer_name, i.rise_date, i.news, i.genre, i.photo_url,i.is_watch_later)

            }
        }
        genreDetailLD.value = result
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}