package com.ubaya.a160419009_newskoeid.model

data class News(
    val id:String?,
    val title:String?,
    val writer_name:String?,
    val rise_date:String?,
    val news: String?,
    val genre: String?,
    val photo_url: String
)

data class Profil(
    val username:String?,
    val name:String?,
    val email:String?,
    val bod:String?,
    val phone_num:String?,
    val slogans:String?,
    val photo_url:String
)

data class Friends(
    val username:String?,
    val name:String?,
    val email:String?,
    val bod:String?,
    val phone_num:String?,
    val slogans:String?,
    val photo_url:String
)

data class NewsWatchLater(
    val id:String?,
    val title:String?,
    val writer_name:String?,
    val rise_date:String?,
    val news: String?,
    val genre: String?,
    val photo_url: String
)

data class Genre(
    val nama_genre:String?,
    val icon_genre:String
)