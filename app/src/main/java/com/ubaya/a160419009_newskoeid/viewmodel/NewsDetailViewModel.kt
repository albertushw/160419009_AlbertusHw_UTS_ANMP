package com.ubaya.a160419009_newskoeid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.a160419009_newskoeid.model.News
import com.ubaya.a160419009_newskoeid.util.Global
import java.util.ArrayList

class NewsDetailViewModel(application: Application):AndroidViewModel(application) {

    val newsLD = MutableLiveData<News>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun fetch(idNews:String){
        for(i in Global.listOfNews){
            if(i.id == idNews){
                val result = News(i.id,i.title,i.writer_name,i.rise_date,i.news,i.genre,i.photo_url)
                newsLD.value = result
            }
        }
    }
}